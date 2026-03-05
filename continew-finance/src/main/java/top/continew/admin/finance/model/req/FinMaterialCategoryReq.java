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

/**
 * 物料分类创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
@Data
@Schema(description = "物料分类创建或修改参数")
public class FinMaterialCategoryReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 父分类ID
     */
    @Schema(description = "父分类ID")
    private Long parentId;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    @NotBlank(message = "分类名称不能为空")
    @Length(max = 100, message = "分类名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 树路径
     */
    @Schema(description = "树路径")
    @Length(max = 255, message = "树路径长度不能超过 {max} 个字符")
    private String treePath;

    /**
     * 排序
     */
    @Schema(description = "排序")
    @NotNull(message = "排序不能为空")
    private Integer sort;

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
