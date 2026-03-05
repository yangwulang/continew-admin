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
import java.time.*;

/**
 * 记账记录查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Data
@Schema(description = "记账记录查询条件")
public class FinBillingRecordQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)
     */
    @Schema(description = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)")
    @Query(type = QueryType.EQ)
    private String status;
}
