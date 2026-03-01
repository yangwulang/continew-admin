package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 记账明细创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:12:26
 */
@Data
@Schema(description = "记账明细创建或修改参数")
public class FinBillingItemReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 记账记录ID
     */
    @Schema(description = "记账记录ID")
    @NotNull(message = "记账记录ID不能为空")
    private Long billingRecordId;

    /**
     * 物料ID
     */
    @Schema(description = "物料ID")
    @NotNull(message = "物料ID不能为空")
    private Long materialId;

    /**
     * 物料名称
     */
    @Schema(description = "物料名称")
    @NotBlank(message = "物料名称不能为空")
    @Length(max = 200, message = "物料名称长度不能超过 {max} 个字符")
    private String materialName;

    /**
     * 单价
     */
    @Schema(description = "单价")
    @NotNull(message = "单价不能为空")
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    @Schema(description = "数量")
    @NotNull(message = "数量不能为空")
    private BigDecimal quantity;

    /**
     * 金额
     */
    @Schema(description = "金额")
    @NotNull(message = "金额不能为空")
    private BigDecimal amount;

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
