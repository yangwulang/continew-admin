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

package top.continew.admin.finance.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;

import top.continew.admin.common.base.model.resp.BaseDetailResp;
import top.continew.starter.extension.crud.annotation.TreeField;
import java.io.Serial;

/**
 * 物料分类详情信息
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
@Data
@ExcelIgnoreUnannotated
@TreeField(value = "id", nameKey = "name")
@Schema(description = "物料分类详情信息")
public class FinMaterialCategoryDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 父分类ID
     */
    @Schema(description = "父分类ID")
    @ExcelProperty(value = "父分类ID")
    private Long parentId;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    @ExcelProperty(value = "分类名称")
    private String name;

    /**
     * 树路径
     */
    @Schema(description = "树路径")
    @ExcelProperty(value = "树路径")
    private String treePath;

    /**
     * 排序
     */
    @Schema(description = "排序")
    @ExcelProperty(value = "排序")
    private Integer sort;

    /**
     * 状态(1-启用,2-禁用)
     */
    @Schema(description = "状态(1-启用,2-禁用)")
    @ExcelProperty(value = "状态(1-启用,2-禁用)")
    private Integer status;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    @ExcelProperty(value = "是否删除（0-否，其他-是）")
    private Long deleted;
}
