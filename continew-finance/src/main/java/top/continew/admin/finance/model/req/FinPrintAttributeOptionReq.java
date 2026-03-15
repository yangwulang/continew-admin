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
 * 打印属性选项创建或修改参数
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:35
 */
@Data
@Schema(description = "打印属性选项创建或修改参数")
public class FinPrintAttributeOptionReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 所属属性ID
     */
    @Schema(description = "所属属性ID")
    @NotNull(message = "所属属性ID不能为空")
    private Long attributeId;

    /**
     * 选项名称
     */
    @Schema(description = "选项名称")
    @NotBlank(message = "选项名称不能为空")
    @Length(max = 50, message = "选项名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 选项编码
     */
    @Schema(description = "选项编码")
    @NotBlank(message = "选项编码不能为空")
    @Length(max = 50, message = "选项编码长度不能超过 {max} 个字符")
    private String code;

    /**
     * 计价方式(PER_PAGE-按页/FIXED-固定/MULTIPLIER-乘数)
     */
    @Schema(description = "计价方式(PER_PAGE-按页/FIXED-固定/MULTIPLIER-乘数)")
    @NotBlank(message = "计价方式(PER_PAGE-按页/FIXED-固定/MULTIPLIER-乘数)不能为空")
    @Length(max = 20, message = "计价方式(PER_PAGE-按页/FIXED-固定/MULTIPLIER-乘数)长度不能超过 {max} 个字符")
    private String priceMode;

    /**
     * 价格值
     */
    @Schema(description = "价格值")
    @NotNull(message = "价格值不能为空")
    private BigDecimal price;

    /**
     * 是否默认选项
     */
    @Schema(description = "是否默认选项")
    @NotNull(message = "是否默认选项不能为空")
    private Boolean isDefault;

    /**
     * 排序号
     */
    @Schema(description = "排序号")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    /**
     * 状态(1-启用, 2-禁用)
     */
    @Schema(description = "状态(1-启用, 2-禁用)")
    @NotNull(message = "状态(1-启用, 2-禁用)不能为空")
    private Integer status;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
