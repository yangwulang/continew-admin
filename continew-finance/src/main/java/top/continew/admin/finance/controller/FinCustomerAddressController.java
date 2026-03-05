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

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinCustomerAddressQuery;
import top.continew.admin.finance.model.req.FinCustomerAddressReq;
import top.continew.admin.finance.model.resp.FinCustomerAddressDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerAddressResp;
import top.continew.admin.finance.service.FinCustomerAddressService;
import top.continew.starter.web.model.R;

/**
 * 客户地址管理 API
 *
 * @author generator
 * @since 2026-03-01 21:11:17
 */
@Tag(name = "客户地址管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-customer-address", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE,
    Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinCustomerAddressController extends BaseController<FinCustomerAddressService, FinCustomerAddressResp, FinCustomerAddressDetailResp, FinCustomerAddressQuery, FinCustomerAddressReq> {

    @Operation(summary = "设为默认地址")
    @PutMapping("/{id}/default")
    public R<Void> setDefault(@PathVariable Long id) {
        baseService.setDefault(id);
        return R.ok();
    }
}
