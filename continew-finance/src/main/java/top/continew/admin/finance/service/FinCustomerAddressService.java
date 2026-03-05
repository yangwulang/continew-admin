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
import top.continew.admin.finance.model.entity.FinCustomerAddressDO;
import top.continew.admin.finance.model.query.FinCustomerAddressQuery;
import top.continew.admin.finance.model.req.FinCustomerAddressReq;
import top.continew.admin.finance.model.resp.FinCustomerAddressDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerAddressResp;
import top.continew.starter.data.service.IService;

/**
 * 客户地址业务接口
 *
 * @author generator
 * @since 2026-03-01 21:11:17
 */
public interface FinCustomerAddressService extends BaseService<FinCustomerAddressResp, FinCustomerAddressDetailResp, FinCustomerAddressQuery, FinCustomerAddressReq>, IService<FinCustomerAddressDO> {

    /**
     * 设为默认地址
     *
     * @param id 地址ID
     */
    void setDefault(Long id);
}
