package top.continew.admin.finance.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;
import java.io.Serial;
import java.io.Serializable;
import java.time.*;
import java.math.BigDecimal;

/**
 * 记账记录查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Data
@Schema(description = "记账记录查询条件")
public class FinBillingRecordQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)
     */
    @Schema(description = "状态(DRAFT/PENDING_SIGN/PENDING_REVIEW/CONFIRMED/REJECTED/CANCELLED)")
    @Query(type = QueryType.EQ)
    private String status;
}
