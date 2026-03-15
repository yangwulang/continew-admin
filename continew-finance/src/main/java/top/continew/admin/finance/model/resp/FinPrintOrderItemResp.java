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

import top.continew.admin.common.base.model.resp.BaseResp;
import java.io.Serial;
import java.math.BigDecimal;

/**
 * 打印订单文件项信息
 *
 * @author AI Generator
 * @since 2026-03-05 19:57:13
 */
@Data
@Schema(description = "打印订单文件项信息")
public class FinPrintOrderItemResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @Schema(description = "订单ID")
    private Long orderId;

    /**
     * 文件地址
     */
    @Schema(description = "文件地址")
    private String fileUrl;

    /**
     * 文件名
     */
    @Schema(description = "文件名")
    private String fileName;

    /**
     * 页数
     */
    @Schema(description = "页数")
    private Integer pageCount;

    /**
     * 份数
     */
    @Schema(description = "份数")
    private Integer copies;

    /**
     * 小计金额
     */
    @Schema(description = "小计金额")
    private BigDecimal subtotalAmount;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
