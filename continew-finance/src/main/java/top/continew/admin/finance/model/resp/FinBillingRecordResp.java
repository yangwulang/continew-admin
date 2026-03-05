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
import java.time.*;
import java.math.BigDecimal;

/**
 * 记账记录信息
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Data
@Schema(description = "记账记录信息")
public class FinBillingRecordResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    private Long customerId;

    /**
     * 记账日期
     */
    @Schema(description = "记账日期")
    private LocalDate billingDate;

    /**
     * 总金额
     */
    @Schema(description = "总金额")
    private BigDecimal totalAmount;

    /**
     * 状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)
     */
    @Schema(description = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)")
    private String status;

    /**
     * 签名链接Token
     */
    @Schema(description = "签名链接Token")
    private String signLinkToken;

    /**
     * 签名访问URL
     */
    @Schema(description = "签名访问URL")
    private String signUrl;

    /**
     * 签名时间
     */
    @Schema(description = "签名时间")
    private LocalDateTime signedAt;

    /**
     * 签名图片地址
     */
    @Schema(description = "签名图片地址")
    private String signImageUrl;

    /**
     * 签名IP
     */
    @Schema(description = "签名IP")
    private String signClientIp;

    /**
     * 审核人ID
     */
    @Schema(description = "审核人ID")
    private Long reviewedBy;

    /**
     * 审核时间
     */
    @Schema(description = "审核时间")
    private LocalDateTime reviewedAt;

    /**
     * 审核备注
     */
    @Schema(description = "审核备注")
    private String reviewRemark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
