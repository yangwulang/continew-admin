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
