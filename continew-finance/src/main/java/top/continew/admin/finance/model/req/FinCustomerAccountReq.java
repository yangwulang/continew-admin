package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 客户账户创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
@Data
@Schema(description = "客户账户创建或修改参数")
public class FinCustomerAccountReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 当前余额
     */
    @Schema(description = "当前余额")
    @NotNull(message = "当前余额不能为空")
    private BigDecimal balance;

    /**
     * 币种
     */
    @Schema(description = "币种")
    @Length(max = 20, message = "币种长度不能超过 {max} 个字符")
    private String currency;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
