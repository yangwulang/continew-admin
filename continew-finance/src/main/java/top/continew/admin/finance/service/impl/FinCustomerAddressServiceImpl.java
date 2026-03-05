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

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.mapper.FinCustomerAddressMapper;
import top.continew.admin.finance.model.entity.FinCustomerAddressDO;
import top.continew.admin.finance.model.query.FinCustomerAddressQuery;
import top.continew.admin.finance.model.req.FinCustomerAddressReq;
import top.continew.admin.finance.model.resp.FinCustomerAddressDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerAddressResp;
import top.continew.admin.finance.service.FinCustomerAddressService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.core.exception.BusinessException;

/**
 * 客户地址业务实现
 *
 * @author generator
 * @since 2026-03-01 21:11:17
 */
@Service
@RequiredArgsConstructor
public class FinCustomerAddressServiceImpl extends BaseServiceImpl<FinCustomerAddressMapper, FinCustomerAddressDO, FinCustomerAddressResp, FinCustomerAddressDetailResp, FinCustomerAddressQuery, FinCustomerAddressReq> implements FinCustomerAddressService {

    @Override
    public PageResp<FinCustomerAddressResp> page(FinCustomerAddressQuery query, PageQuery pageQuery) {
        IPage<FinCustomerAddressResp> page = baseMapper.selectPageWithJoin(new Page<>(pageQuery.getPage(), pageQuery
            .getSize()), query);
        return PageResp.build(page);
    }

    @Override
    public FinCustomerAddressDetailResp get(Long id) {
        FinCustomerAddressDetailResp detail = baseMapper.selectDetailById(id);
        return detail;
    }

    @Override
    public void afterCreate(FinCustomerAddressReq req, FinCustomerAddressDO entity) {
        // 如果新增的是默认地址，取消该客户其他默认地址
        if (Boolean.TRUE.equals(req.getIsDefault())) {
            clearOtherDefault(req.getCustomerId(), entity.getId());
        }
    }

    @Override
    public void afterUpdate(FinCustomerAddressReq req, FinCustomerAddressDO entity) {
        // 如果修改为默认地址，取消该客户其他默认地址
        if (Boolean.TRUE.equals(req.getIsDefault())) {
            clearOtherDefault(req.getCustomerId(), entity.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setDefault(Long id) {
        FinCustomerAddressDO address = this.getById(id);
        if (address == null) {
            throw new BusinessException("地址不存在");
        }
        // 取消该客户其他默认地址
        clearOtherDefault(address.getCustomerId(), id);
        // 设置当前地址为默认
        address.setIsDefault(true);
        this.updateById(address);
    }

    /**
     * 清除该客户其他默认地址
     */
    private void clearOtherDefault(Long customerId, Long excludeId) {
        this.update(new LambdaUpdateWrapper<FinCustomerAddressDO>().set(FinCustomerAddressDO::getIsDefault, false)
            .eq(FinCustomerAddressDO::getCustomerId, customerId)
            .eq(FinCustomerAddressDO::getIsDefault, true)
            .ne(FinCustomerAddressDO::getId, excludeId)
            .eq(FinCustomerAddressDO::getDeleted, 0));
    }
}
