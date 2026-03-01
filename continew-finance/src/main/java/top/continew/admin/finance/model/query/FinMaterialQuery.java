package top.continew.admin.finance.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 物料信息查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
@Data
@Schema(description = "物料信息查询条件")
public class FinMaterialQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    @Schema(description = "分类ID")
    @Query(type = QueryType.EQ)
    private Long categoryId;

    /**
     * 物料名称
     */
    @Schema(description = "物料名称")
    @Query(type = QueryType.LIKE)
    private String name;

    /**
     * 状态(1-启用,2-禁用)
     */
    @Schema(description = "状态(1-启用,2-禁用)")
    @Query(type = QueryType.EQ)
    private Integer status;
}
