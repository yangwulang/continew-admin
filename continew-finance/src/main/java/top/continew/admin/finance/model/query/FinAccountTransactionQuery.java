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
 * 账户交易查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
@Data
@Schema(description = "账户交易查询条件")
public class FinAccountTransactionQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 交易类型(RECHARGE/DEBIT_BILLING)
     */
    @Schema(description = "交易类型(RECHARGE/DEBIT_BILLING)")
    @Query(type = QueryType.EQ)
    private String type;

    /**
     * 交易状态(PENDING/CONFIRMED/CANCELLED)
     */
    @Schema(description = "交易状态(PENDING/CONFIRMED/CANCELLED)")
    @Query(type = QueryType.EQ)
    private String status;
}
