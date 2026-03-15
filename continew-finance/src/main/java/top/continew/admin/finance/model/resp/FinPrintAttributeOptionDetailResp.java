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
import java.io.Serial;
import java.math.BigDecimal;

/**
 * 打印属性选项详情信息
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:35
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "打印属性选项详情信息")
public class FinPrintAttributeOptionDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 所属属性ID
     */
    @Schema(description = "所属属性ID")
    @ExcelProperty(value = "所属属性ID")
    private Long attributeId;

    /**
     * 选项名称
     */
    @Schema(description = "选项名称")
    @ExcelProperty(value = "选项名称")
    private String name;

    /**
     * 选项编码
     */
    @Schema(description = "选项编码")
    @ExcelProperty(value = "选项编码")
    private String code;

    /**
     * 计价方式(PER_PAGE-按页/FIXED-固定/MULTIPLIER-乘数)
     */
    @Schema(description = "计价方式(PER_PAGE-按页/FIXED-固定/MULTIPLIER-乘数)")
    @ExcelProperty(value = "计价方式(PER_PAGE-按页/FIXED-固定/MULTIPLIER-乘数)")
    private String priceMode;

    /**
     * 价格值
     */
    @Schema(description = "价格值")
    @ExcelProperty(value = "价格值")
    private BigDecimal price;

    /**
     * 是否默认选项
     */
    @Schema(description = "是否默认选项")
    @ExcelProperty(value = "是否默认选项")
    private Boolean isDefault;

    /**
     * 排序号
     */
    @Schema(description = "排序号")
    @ExcelProperty(value = "排序号")
    private Integer sort;

    /**
     * 状态(1-启用, 2-禁用)
     */
    @Schema(description = "状态(1-启用, 2-禁用)")
    @ExcelProperty(value = "状态(1-启用, 2-禁用)")
    private Integer status;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    @ExcelProperty(value = "是否删除（0-否，其他-是）")
    private Long deleted;
}
