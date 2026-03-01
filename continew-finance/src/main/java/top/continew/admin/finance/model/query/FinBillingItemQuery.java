package top.continew.admin.finance.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 记账明细查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:12:26
 */
@Data
@Schema(description = "记账明细查询条件")
public class FinBillingItemQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 物料名称
     */
    @Schema(description = "物料名称")
    @Query(type = QueryType.LIKE)
    private String materialName;
}
