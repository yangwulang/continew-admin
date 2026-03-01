package top.continew.admin.finance.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;

import top.continew.admin.common.base.model.resp.BaseDetailResp;
import top.continew.starter.excel.converter.ExcelBaseEnumConverter;
import java.io.Serial;
import java.math.BigDecimal;

/**
 * 物料信息详情信息
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "物料信息详情信息")
public class FinMaterialDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    @Schema(description = "分类ID")
    @ExcelProperty(value = "分类ID")
    private Long categoryId;

    /**
     * 物料名称
     */
    @Schema(description = "物料名称")
    @ExcelProperty(value = "物料名称")
    private String name;

    /**
     * 物料编码
     */
    @Schema(description = "物料编码")
    @ExcelProperty(value = "物料编码")
    private String code;

    /**
     * 默认单价
     */
    @Schema(description = "默认单价")
    @ExcelProperty(value = "默认单价")
    private BigDecimal defaultUnitPrice;

    /**
     * 计量单位
     */
    @Schema(description = "计量单位")
    @ExcelProperty(value = "计量单位")
    private String unit;

    /**
     * 状态(1-启用,2-禁用)
     */
    @Schema(description = "状态(1-启用,2-禁用)")
    @ExcelProperty(value = "状态(1-启用,2-禁用)")
    private Integer status;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    @ExcelProperty(value = "是否删除（0-否，其他-是）")
    private Long deleted;
}
