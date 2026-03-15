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

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 打印价格计算结果（多文件）
 *
 * @author AI Generator
 * @since 2026-03-05
 */
@Data
@Schema(description = "打印价格计算结果")
public class PrintPriceCalculateResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单总金额（所有文件项合计）
     */
    @Schema(description = "订单总金额")
    private BigDecimal totalAmount;

    /**
     * 各文件项价格结果
     */
    @Schema(description = "各文件项价格结果")
    private List<ItemPriceResult> items;

    /**
     * 单个文件项的价格计算结果
     */
    @Data
    @Schema(description = "文件项价格结果")
    public static class ItemPriceResult implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        @Schema(description = "文件名")
        private String fileName;

        @Schema(description = "每页单价合计")
        private BigDecimal perPageSum;

        @Schema(description = "页数费用")
        private BigDecimal pageCost;

        @Schema(description = "乘数调整后费用")
        private BigDecimal multipliedCost;

        @Schema(description = "固定费用合计")
        private BigDecimal fixedSum;

        @Schema(description = "该项小计金额")
        private BigDecimal subtotalAmount;

        @Schema(description = "价格明细列表")
        private List<PriceDetail> details;
    }

    /**
     * 价格明细项
     */
    @Data
    @Schema(description = "价格明细项")
    public static class PriceDetail implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        @Schema(description = "属性名称")
        private String attributeName;

        @Schema(description = "选项名称")
        private String optionName;

        @Schema(description = "计价方式")
        private String priceMode;

        @Schema(description = "价格值")
        private BigDecimal price;

        @Schema(description = "该项计算金额")
        private BigDecimal calculatedAmount;
    }
}
