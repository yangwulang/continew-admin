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

package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;

import java.io.Serial;
import java.time.*;
import java.math.BigDecimal;

/**
 * 客户物料价格实体
 *
 * @author Qoder
 * @since 2026-02-25 16:12:15
 */
@Data
@TableName("fin_customer_material_price")
public class FinCustomerMaterialPriceDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 物料ID
     */
    private Long materialId;

    /**
     * 专属单价
     */
    private BigDecimal unitPrice;

    /**
     * 生效时间
     */
    private LocalDateTime effectiveFrom;

    /**
     * 失效时间
     */
    private LocalDateTime effectiveTo;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
