package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 记账明细（创建记账专用）参数
 *
 * @author Qoder
 */
@Data
@Schema(description = "记账明细（创建记账专用）参数")
public class FinBillingCreateItemReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 物料ID
     */
    @Schema(description = "物料ID")
    @NotNull(message = "物料ID不能为空")
    private Long materialId;

    /**
     * 数量
     */
    @Schema(description = "数量")
    @NotNull(message = "数量不能为空")
    private BigDecimal quantity;

    /**
     * 单价（为空则按计价规则自动计算）
     */
    @Schema(description = "单价（为空则按计价规则自动计算）")
    private BigDecimal unitPrice;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 500, message = "备注长度不能超过 {max} 个字符")
    private String remark;
}
