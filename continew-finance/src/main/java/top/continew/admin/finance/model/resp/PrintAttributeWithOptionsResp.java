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
 * 打印属性(含选项)响应
 *
 * @author AI Generator
 * @since 2026-03-05
 */
@Data
@Schema(description = "打印属性(含选项)响应")
public class PrintAttributeWithOptionsResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "属性ID")
    private Long id;

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "属性编码")
    private String code;

    @Schema(description = "输入类型(SELECT/MULTI_SELECT)")
    private String inputType;

    @Schema(description = "是否必选")
    private Boolean isRequired;

    @Schema(description = "排序号")
    private Integer sort;

    @Schema(description = "选项列表")
    private List<OptionItem> options;

    @Data
    @Schema(description = "属性选项项")
    public static class OptionItem implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        @Schema(description = "选项ID")
        private Long id;

        @Schema(description = "选项名称")
        private String name;

        @Schema(description = "选项编码")
        private String code;

        @Schema(description = "计价方式(PER_PAGE/FIXED/MULTIPLIER)")
        private String priceMode;

        @Schema(description = "价格值")
        private BigDecimal price;

        @Schema(description = "是否默认选项")
        private Boolean isDefault;

        @Schema(description = "排序号")
        private Integer sort;
    }
}
