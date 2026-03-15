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
 * 打印订单选项详情信息
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:49
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "打印订单选项详情信息")
public class FinPrintOrderOptionDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单项ID
     */
    @Schema(description = "订单项ID")
    @ExcelProperty(value = "订单项ID")
    private Long itemId;

    /**
     * 属性ID
     */
    @Schema(description = "属性ID")
    @ExcelProperty(value = "属性ID")
    private Long attributeId;

    /**
     * 属性名称
     */
    @Schema(description = "属性名称")
    @ExcelProperty(value = "属性名称")
    private String attributeName;

    /**
     * 选项ID
     */
    @Schema(description = "选项ID")
    @ExcelProperty(value = "选项ID")
    private Long optionId;

    /**
     * 选项名称
     */
    @Schema(description = "选项名称")
    @ExcelProperty(value = "选项名称")
    private String optionName;

    /**
     * 计价方式
     */
    @Schema(description = "计价方式")
    @ExcelProperty(value = "计价方式")
    private String priceMode;

    /**
     * 价格值
     */
    @Schema(description = "价格值")
    @ExcelProperty(value = "价格值")
    private BigDecimal price;

    /**
     * 计算金额
     */
    @Schema(description = "计算金额")
    @ExcelProperty(value = "计算金额")
    private BigDecimal calculatedAmount;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    @ExcelProperty(value = "是否删除（0-否，其他-是）")
    private Long deleted;
}
