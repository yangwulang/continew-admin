package top.continew.admin.finance.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.base.model.resp.BaseResp;
import java.io.Serial;
import java.time.*;
import java.math.BigDecimal;

/**
 * 账户交易信息
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
@Data
@Schema(description = "账户交易信息")
public class FinAccountTransactionResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    private Long customerId;

    /**
     * 交易类型(RECHARGE/DEBIT_BILLING)
     */
    @Schema(description = "交易类型(RECHARGE/DEBIT_BILLING)")
    private String type;

    /**
     * 收支方向(IN/OUT)
     */
    @Schema(description = "收支方向(IN/OUT)")
    private String direction;

    /**
     * 交易金额
     */
    @Schema(description = "交易金额")
    private BigDecimal amount;

    /**
     * 变动后余额
     */
    @Schema(description = "变动后余额")
    private BigDecimal balanceAfter;

    /**
     * 关联记账记录ID
     */
    @Schema(description = "关联记账记录ID")
    private Long billingRecordId;

    /**
     * 充值/支付渠道
     */
    @Schema(description = "充值/支付渠道")
    private String channel;

    /**
     * 交易状态(PENDING/CONFIRMED/CANCELLED)
     */
    @Schema(description = "交易状态(PENDING/CONFIRMED/CANCELLED)")
    private String status;

    /**
     * 业务发生时间
     */
    @Schema(description = "业务发生时间")
    private LocalDateTime occurTime;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
