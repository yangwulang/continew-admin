package top.continew.admin.finance.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.base.model.resp.BaseResp;
import java.io.Serial;
import java.math.BigDecimal;

/**
 * 客户账户信息
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
@Data
@Schema(description = "客户账户信息")
public class FinCustomerAccountResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    private Long customerId;

    /**
     * 当前余额
     */
    @Schema(description = "当前余额")
    private BigDecimal balance;

    /**
     * 币种
     */
    @Schema(description = "币种")
    private String currency;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
