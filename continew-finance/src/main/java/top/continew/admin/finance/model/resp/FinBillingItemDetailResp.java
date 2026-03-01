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
 * 记账明细详情信息
 *
 * @author Qoder
 * @since 2026-02-25 16:12:26
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "记账明细详情信息")
public class FinBillingItemDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 记账记录ID
     */
    @Schema(description = "记账记录ID")
    @ExcelProperty(value = "记账记录ID")
    private Long billingRecordId;

    /**
     * 物料ID
     */
    @Schema(description = "物料ID")
    @ExcelProperty(value = "物料ID")
    private Long materialId;

    /**
     * 物料名称
     */
    @Schema(description = "物料名称")
    @ExcelProperty(value = "物料名称")
    private String materialName;

    /**
     * 单价
     */
    @Schema(description = "单价")
    @ExcelProperty(value = "单价")
    private BigDecimal unitPrice;

    /**
     * 数量
     */
    @Schema(description = "数量")
    @ExcelProperty(value = "数量")
    private BigDecimal quantity;

    /**
     * 金额
     */
    @Schema(description = "金额")
    @ExcelProperty(value = "金额")
    private BigDecimal amount;

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
