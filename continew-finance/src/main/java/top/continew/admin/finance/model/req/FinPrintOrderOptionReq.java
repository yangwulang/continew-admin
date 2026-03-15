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
 * 打印订单选项创建或修改参数
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:49
 */
@Data
@Schema(description = "打印订单选项创建或修改参数")
public class FinPrintOrderOptionReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单项ID
     */
    @Schema(description = "订单项ID")
    @NotNull(message = "订单项ID不能为空")
    private Long itemId;

    /**
     * 属性ID
     */
    @Schema(description = "属性ID")
    @NotNull(message = "属性ID不能为空")
    private Long attributeId;

    /**
     * 属性名称
     */
    @Schema(description = "属性名称")
    @NotBlank(message = "属性名称不能为空")
    @Length(max = 50, message = "属性名称长度不能超过 {max} 个字符")
    private String attributeName;

    /**
     * 选项ID
     */
    @Schema(description = "选项ID")
    @NotNull(message = "选项ID不能为空")
    private Long optionId;

    /**
     * 选项名称
     */
    @Schema(description = "选项名称")
    @NotBlank(message = "选项名称不能为空")
    @Length(max = 50, message = "选项名称长度不能超过 {max} 个字符")
    private String optionName;

    /**
     * 计价方式
     */
    @Schema(description = "计价方式")
    @NotBlank(message = "计价方式不能为空")
    @Length(max = 20, message = "计价方式长度不能超过 {max} 个字符")
    private String priceMode;

    /**
     * 价格值
     */
    @Schema(description = "价格值")
    @NotNull(message = "价格值不能为空")
    private BigDecimal price;

    /**
     * 计算金额
     */
    @Schema(description = "计算金额")
    @NotNull(message = "计算金额不能为空")
    private BigDecimal calculatedAmount;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
