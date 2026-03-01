package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 客户充值参数
 *
 * @author Qoder
 */
@Data
@Schema(description = "客户充值参数")
public class FinRechargeReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 充值金额
     */
    @Schema(description = "充值金额")
    @NotNull(message = "充值金额不能为空")
    private BigDecimal amount;

    /**
     * 充值渠道
     */
    @Schema(description = "充值渠道")
    @Length(max = 50, message = "充值渠道长度不能超过 {max} 个字符")
    private String channel;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 500, message = "备注长度不能超过 {max} 个字符")
    private String remark;
}
