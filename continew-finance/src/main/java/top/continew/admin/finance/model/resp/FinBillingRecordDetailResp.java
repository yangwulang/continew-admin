package top.continew.admin.finance.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;

import top.continew.admin.common.base.model.resp.BaseDetailResp;
import top.continew.starter.excel.converter.ExcelBaseEnumConverter;
import java.io.Serial;
import java.time.*;
import java.math.BigDecimal;

/**
 * 记账记录详情信息
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "记账记录详情信息")
public class FinBillingRecordDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @ExcelProperty(value = "客户ID")
    private Long customerId;

    /**
     * 记账日期
     */
    @Schema(description = "记账日期")
    @ExcelProperty(value = "记账日期")
    private LocalDate billingDate;

    /**
     * 总金额
     */
    @Schema(description = "总金额")
    @ExcelProperty(value = "总金额")
    private BigDecimal totalAmount;

    /**
     * 状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)
     */
    @Schema(description = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)")
    @ExcelProperty(value = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)")
    private String status;

    /**
     * 签名链接Token
     */
    @Schema(description = "签名链接Token")
    @ExcelProperty(value = "签名链接Token")
    private String signLinkToken;

    /**
     * 签名访问URL
     */
    @Schema(description = "签名访问URL")
    @ExcelProperty(value = "签名访问URL")
    private String signUrl;

    /**
     * 签名时间
     */
    @Schema(description = "签名时间")
    @ExcelProperty(value = "签名时间")
    private LocalDateTime signedAt;

    /**
     * 签名图片地址
     */
    @Schema(description = "签名图片地址")
    @ExcelProperty(value = "签名图片地址")
    private String signImageUrl;

    /**
     * 签名IP
     */
    @Schema(description = "签名IP")
    @ExcelProperty(value = "签名IP")
    private String signClientIp;

    /**
     * 审核人ID
     */
    @Schema(description = "审核人ID")
    @ExcelProperty(value = "审核人ID")
    private Long reviewedBy;

    /**
     * 审核时间
     */
    @Schema(description = "审核时间")
    @ExcelProperty(value = "审核时间")
    private LocalDateTime reviewedAt;

    /**
     * 审核备注
     */
    @Schema(description = "审核备注")
    @ExcelProperty(value = "审核备注")
    private String reviewRemark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    @ExcelProperty(value = "是否删除（0-否，其他-是）")
    private Long deleted;
}
