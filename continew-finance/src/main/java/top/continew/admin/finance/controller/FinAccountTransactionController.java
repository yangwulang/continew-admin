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

package top.continew.admin.finance.controller;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinAccountTransactionQuery;
import top.continew.admin.finance.model.req.FinAccountTransactionReq;
import top.continew.admin.finance.model.req.FinRechargeReq;
import top.continew.admin.finance.model.resp.FinAccountTransactionDetailResp;
import top.continew.admin.finance.model.resp.FinAccountTransactionResp;
import top.continew.admin.finance.service.FinAccountTransactionService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 账户交易管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
@Tag(name = "账户交易管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-account-transaction", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE,
    Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinAccountTransactionController extends BaseController<FinAccountTransactionService, FinAccountTransactionResp, FinAccountTransactionDetailResp, FinAccountTransactionQuery, FinAccountTransactionReq> {

    @Operation(summary = "客户充值", description = "为客户新增一笔充值记录，并更新账户余额")
    @PostMapping("/recharge")
    public Long recharge(@RequestBody @Valid FinRechargeReq req) {
        return baseService.recharge(req);
    }
}
