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
import java.math.BigDecimal;

/**
 * 打印订单实体
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:44
 */
@Data
@TableName("fin_print_order")
public class FinPrintOrderDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 状态(PENDING/CONFIRMED/PRINTING/COMPLETED/CANCELLED)
     */
    private String status;

    /**
     * 关联记账记录ID
     */
    private Long billingRecordId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
