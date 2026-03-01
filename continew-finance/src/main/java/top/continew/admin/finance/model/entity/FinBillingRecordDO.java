package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;


import java.io.Serial;
import java.time.*;
import java.math.BigDecimal;

/**
 * 记账记录实体
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Data
@TableName("fin_billing_record")
public class FinBillingRecordDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 记账日期
     */
    private LocalDate billingDate;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)
     */
    private String status;

    /**
     * 签名链接Token
     */
    private String signLinkToken;

    /**
     * 签名访问URL
     */
    private String signUrl;

    /**
     * 签名时间
     */
    private LocalDateTime signedAt;

    /**
     * 签名图片地址
     */
    private String signImageUrl;

    /**
     * 签名IP
     */
    private String signClientIp;

    /**
     * 审核人ID
     */
    private Long reviewedBy;

    /**
     * 审核时间
     */
    private LocalDateTime reviewedAt;

    /**
     * 审核备注
     */
    private String reviewRemark;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
