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

package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 打印订单创建或修改参数
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:44
 */
@Data
@Schema(description = "打印订单创建或修改参数")
public class FinPrintOrderReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    @NotBlank(message = "订单编号不能为空")
    @Length(max = 32, message = "订单编号长度不能超过 {max} 个字符")
    private String orderNo;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 订单总金额
     */
    @Schema(description = "订单总金额")
    @NotNull(message = "订单总金额不能为空")
    private BigDecimal totalAmount;

    /**
     * 状态(PENDING/CONFIRMED/PRINTING/COMPLETED/CANCELLED)
     */
    @Schema(description = "状态(PENDING/CONFIRMED/PRINTING/COMPLETED/CANCELLED)")
    @NotBlank(message = "状态(PENDING/CONFIRMED/PRINTING/COMPLETED/CANCELLED)不能为空")
    @Length(max = 20, message = "状态(PENDING/CONFIRMED/PRINTING/COMPLETED/CANCELLED)长度不能超过 {max} 个字符")
    private String status;

    /**
     * 关联记账记录ID
     */
    @Schema(description = "关联记账记录ID")
    private Long billingRecordId;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 500, message = "备注长度不能超过 {max} 个字符")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
