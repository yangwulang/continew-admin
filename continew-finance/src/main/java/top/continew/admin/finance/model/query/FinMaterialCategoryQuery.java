package top.continew.admin.finance.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.annotation.Query;
import top.continew.starter.data.enums.QueryType;
import java.io.Serial;
import java.io.Serializable;

/**
 * 物料分类查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
@Data
@Schema(description = "物料分类查询条件")
public class FinMaterialCategoryQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    @Query(type = QueryType.LIKE)
    private String name;

    /**
     * 状态(1-启用,2-禁用)
     */
    @Schema(description = "状态(1-启用,2-禁用)")
    @Query(type = QueryType.EQ)
    private Integer status;
}
