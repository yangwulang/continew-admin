package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;
import java.math.BigDecimal;

/**
 * 客户物料价格创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:12:15
 */
@Data
@Schema(description = "客户物料价格创建或修改参数")
public class FinCustomerMaterialPriceReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 物料ID
     */
    @Schema(description = "物料ID")
    @NotNull(message = "物料ID不能为空")
    private Long materialId;

    /**
     * 专属单价
     */
    @Schema(description = "专属单价")
    @NotNull(message = "专属单价不能为空")
    private BigDecimal unitPrice;

    /**
     * 生效时间
     */
    @Schema(description = "生效时间")
    @NotNull(message = "生效时间不能为空")
    private LocalDateTime effectiveFrom;

    /**
     * 失效时间
     */
    @Schema(description = "失效时间")
    private LocalDateTime effectiveTo;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
