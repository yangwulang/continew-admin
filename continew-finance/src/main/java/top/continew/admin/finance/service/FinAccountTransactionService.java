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

package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.admin.finance.model.query.FinAccountTransactionQuery;
import top.continew.admin.finance.model.req.FinAccountTransactionReq;
import top.continew.admin.finance.model.req.FinRechargeReq;
import top.continew.admin.finance.model.resp.FinAccountTransactionDetailResp;
import top.continew.admin.finance.model.resp.FinAccountTransactionResp;
import top.continew.starter.data.service.IService;

/**
 * 账户交易业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
public interface FinAccountTransactionService extends BaseService<FinAccountTransactionResp, FinAccountTransactionDetailResp, FinAccountTransactionQuery, FinAccountTransactionReq>, IService<FinAccountTransactionDO> {

    /**
     * 客户充值。
     *
     * @param req 充值参数
     * @return 交易ID
     */
    Long recharge(FinRechargeReq req);
}
