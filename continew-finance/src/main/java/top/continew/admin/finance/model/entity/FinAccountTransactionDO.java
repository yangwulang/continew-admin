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

package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;

import java.io.Serial;
import java.time.*;
import java.math.BigDecimal;

/**
 * 账户交易实体
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
@Data
@TableName("fin_account_transaction")
public class FinAccountTransactionDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 交易类型(RECHARGE/DEBIT_BILLING)
     */
    private String type;

    /**
     * 收支方向(IN/OUT)
     */
    private String direction;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 变动后余额
     */
    private BigDecimal balanceAfter;

    /**
     * 关联记账记录ID
     */
    private Long billingRecordId;

    /**
     * 充值/支付渠道
     */
    private String channel;

    /**
     * 交易状态(PENDING/CONFIRMED/CANCELLED)
     */
    private String status;

    /**
     * 业务发生时间
     */
    private LocalDateTime occurTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
