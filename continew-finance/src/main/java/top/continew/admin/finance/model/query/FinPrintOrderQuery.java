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
 * 打印订单查询条件
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:44
 */
@Data
@Schema(description = "打印订单查询条件")
public class FinPrintOrderQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 原始文件名
     */
    @Schema(description = "原始文件名")
    @Query(type = QueryType.LIKE)
    private String fileName;

    /**
     * 状态(PENDING/CONFIRMED/PRINTING/COMPLETED/CANCELLED)
     */
    @Schema(description = "状态(PENDING/CONFIRMED/PRINTING/COMPLETED/CANCELLED)")
    @Query(type = QueryType.EQ)
    private String status;
}
