/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.finance.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.event.CustomerRechargeEvent;
import top.continew.starter.core.util.validation.CheckUtils;
import top.continew.admin.finance.mapper.FinAccountTransactionMapper;
import top.continew.admin.finance.mapper.FinCustomerAccountMapper;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.admin.finance.model.entity.FinCustomerAccountDO;
import top.continew.admin.finance.model.query.FinAccountTransactionQuery;
import top.continew.admin.finance.model.req.FinAccountTransactionReq;
import top.continew.admin.finance.model.req.FinRechargeReq;
import top.continew.admin.finance.model.resp.FinAccountTransactionDetailResp;
import top.continew.admin.finance.model.resp.FinAccountTransactionResp;
import top.continew.admin.finance.service.FinAccountTransactionService;

/**
 * 账户交易业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
@Service
@RequiredArgsConstructor
public class FinAccountTransactionServiceImpl extends BaseServiceImpl<FinAccountTransactionMapper, FinAccountTransactionDO, FinAccountTransactionResp, FinAccountTransactionDetailResp, FinAccountTransactionQuery, FinAccountTransactionReq> implements FinAccountTransactionService {

    private final FinCustomerAccountMapper finCustomerAccountMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long recharge(FinRechargeReq req) {
        BigDecimal amount = req.getAmount();
        CheckUtils.throwIf(amount == null || amount.compareTo(new BigDecimal("0.01")) <= 0, "充值金额必须大于 0");

        Long customerId = req.getCustomerId();
        FinCustomerAccountDO account = finCustomerAccountMapper.lambdaQuery()
            .eq(FinCustomerAccountDO::getCustomerId, customerId)
            .one();
        if (account == null) {
            account = new FinCustomerAccountDO();
            account.setCustomerId(customerId);
            account.setBalance(BigDecimal.ZERO);
            finCustomerAccountMapper.insert(account);
        }

        BigDecimal balance = account.getBalance() == null ? BigDecimal.ZERO : account.getBalance();
        BigDecimal newBalance = balance.add(amount);
        account.setBalance(newBalance);
        finCustomerAccountMapper.updateById(account);

        FinAccountTransactionReq txReq = new FinAccountTransactionReq();
        txReq.setCustomerId(customerId);
        txReq.setType("RECHARGE");
        txReq.setDirection("IN");
        txReq.setAmount(amount);
        txReq.setBalanceAfter(newBalance);
        txReq.setChannel(req.getChannel());
        txReq.setStatus("CONFIRMED");
        txReq.setOccurTime(LocalDateTime.now());
        txReq.setRemark(req.getRemark());
        return super.create(txReq);
    }

    /**
     * 如果充值成功，则发送充值事件
     *
     * @param req    创建信息
     * @param entity 实体信息
     */
    @Override
    protected void afterCreate(FinAccountTransactionReq req, FinAccountTransactionDO entity) {
        CustomerRechargeEvent customerRechargeEvent = new CustomerRechargeEvent(this, req, entity);
        eventPublisher.publishEvent(customerRechargeEvent);
    }
}
