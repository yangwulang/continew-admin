package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;
import java.io.Serial;
import java.io.Serializable;
import java.time.*;
import java.math.BigDecimal;

/**
 * 账户交易创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
@Data
@Schema(description = "账户交易创建或修改参数")
public class FinAccountTransactionReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 交易类型(RECHARGE/DEBIT_BILLING)
     */
    @Schema(description = "交易类型(RECHARGE/DEBIT_BILLING)")
    @NotBlank(message = "交易类型(RECHARGE/DEBIT_BILLING)不能为空")
    @Length(max = 50, message = "交易类型(RECHARGE/DEBIT_BILLING)长度不能超过 {max} 个字符")
    private String type;

    /**
     * 收支方向(IN/OUT)
     */
    @Schema(description = "收支方向(IN/OUT)")
    @NotBlank(message = "收支方向(IN/OUT)不能为空")
    @Length(max = 10, message = "收支方向(IN/OUT)长度不能超过 {max} 个字符")
    private String direction;

    /**
     * 交易金额
     */
    @Schema(description = "交易金额")
    @NotNull(message = "交易金额不能为空")
    private BigDecimal amount;

    /**
     * 变动后余额
     */
    @Schema(description = "变动后余额")
    @NotNull(message = "变动后余额不能为空")
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
    @Length(max = 50, message = "充值/支付渠道长度不能超过 {max} 个字符")
    private String channel;

    /**
     * 交易状态(PENDING/CONFIRMED/CANCELLED)
     */
    @Schema(description = "交易状态(PENDING/CONFIRMED/CANCELLED)")
    @NotBlank(message = "交易状态(PENDING/CONFIRMED/CANCELLED)不能为空")
    @Length(max = 20, message = "交易状态(PENDING/CONFIRMED/CANCELLED)长度不能超过 {max} 个字符")
    private String status;

    /**
     * 业务发生时间
     */
    @Schema(description = "业务发生时间")
    @NotNull(message = "业务发生时间不能为空")
    private LocalDateTime occurTime;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 500, message = "备注长度不能超过 {max} 个字符")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
