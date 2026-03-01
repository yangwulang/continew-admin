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
 * 记账记录创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Data
@Schema(description = "记账记录创建或修改参数")
public class FinBillingRecordReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 记账日期
     */
    @Schema(description = "记账日期")
    @NotNull(message = "记账日期不能为空")
    private LocalDate billingDate;

    /**
     * 总金额
     */
    @Schema(description = "总金额")
    @NotNull(message = "总金额不能为空")
    private BigDecimal totalAmount;

    /**
     * 状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)
     */
    @Schema(description = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)")
    @NotBlank(message = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)不能为空")
    @Length(max = 30, message = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)长度不能超过 {max} 个字符")
    private String status;

    /**
     * 签名链接Token
     */
    @Schema(description = "签名链接Token")
    @Length(max = 100, message = "签名链接Token长度不能超过 {max} 个字符")
    private String signLinkToken;

    /**
     * 签名访问URL
     */
    @Schema(description = "签名访问URL")
    @Length(max = 255, message = "签名访问URL长度不能超过 {max} 个字符")
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
    @Length(max = 255, message = "签名图片地址长度不能超过 {max} 个字符")
    private String signImageUrl;

    /**
     * 签名IP
     */
    @Schema(description = "签名IP")
    @Length(max = 50, message = "签名IP长度不能超过 {max} 个字符")
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
    @Length(max = 500, message = "审核备注长度不能超过 {max} 个字符")
    private String reviewRemark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
