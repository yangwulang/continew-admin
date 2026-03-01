package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * 记账记录创建（带明细）参数
 *
 * @author Qoder
 */
@Data
@Schema(description = "记账记录创建（带明细）参数")
public class FinBillingCreateReq implements Serializable {

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
     * 记账明细列表
     */
    @Schema(description = "记账明细列表")
    @NotEmpty(message = "记账明细不能为空")
    private List<FinBillingCreateItemReq> items;
}
