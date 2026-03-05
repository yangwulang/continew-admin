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

package top.continew.admin.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.continew.admin.finance.model.resp.FinCustomerAddressResp;
import top.continew.admin.finance.model.resp.FinCustomerAddressDetailResp;
import top.continew.admin.finance.model.entity.FinCustomerAddressDO;
import top.continew.starter.data.mapper.BaseMapper;
import top.continew.admin.finance.model.query.FinCustomerAddressQuery;

/**
 * 客户地址 Mapper
 *
 * @author generator
 * @since 2026-03-01 21:11:17
 */
@Mapper
public interface FinCustomerAddressMapper extends BaseMapper<FinCustomerAddressDO> {

    /**
     * 分页查询客户地址列表（含关联字段）
     */
    IPage<FinCustomerAddressResp> selectPageWithJoin(IPage<FinCustomerAddressDO> page,
                                                     @Param("query") FinCustomerAddressQuery query);

    /**
     * 查询客户地址详情（含关联字段）
     */
    FinCustomerAddressDetailResp selectDetailById(@Param("id") Long id);
}
