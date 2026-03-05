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
 * 物料信息创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
@Data
@Schema(description = "物料信息创建或修改参数")
public class FinMaterialReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    @Schema(description = "分类ID")
    @NotNull(message = "分类ID不能为空")
    private Long categoryId;

    /**
     * 物料名称
     */
    @Schema(description = "物料名称")
    @NotBlank(message = "物料名称不能为空")
    @Length(max = 100, message = "物料名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 物料编码
     */
    @Schema(description = "物料编码")
    @Length(max = 100, message = "物料编码长度不能超过 {max} 个字符")
    private String code;

    /**
     * 默认单价
     */
    @Schema(description = "默认单价")
    @NotNull(message = "默认单价不能为空")
    private BigDecimal defaultUnitPrice;

    /**
     * 计量单位
     */
    @Schema(description = "计量单位")
    @Length(max = 50, message = "计量单位长度不能超过 {max} 个字符")
    private String unit;

    /**
     * 状态(1-启用,2-禁用)
     */
    @Schema(description = "状态(1-启用,2-禁用)")
    @NotNull(message = "状态(1-启用,2-禁用)不能为空")
    private Integer status;

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
