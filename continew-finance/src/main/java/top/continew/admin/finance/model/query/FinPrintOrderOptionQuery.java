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

package top.continew.admin.finance.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;
import java.io.Serial;
import java.io.Serializable;

/**
 * 打印订单选项查询条件
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:49
 */
@Data
@Schema(description = "打印订单选项查询条件")
public class FinPrintOrderOptionQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单项ID
     */
    @Schema(description = "订单项ID")
    @Query(type = QueryType.EQ)
    private Long itemId;

    /**
     * 属性名称
     */
    @Schema(description = "属性名称")
    @Query(type = QueryType.LIKE)
    private String attributeName;

    /**
     * 选项名称
     */
    @Schema(description = "选项名称")
    @Query(type = QueryType.LIKE)
    private String optionName;
}
