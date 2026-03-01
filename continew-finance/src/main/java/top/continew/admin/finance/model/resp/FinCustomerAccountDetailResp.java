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
 * 客户账户详情信息
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "客户账户详情信息")
public class FinCustomerAccountDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @ExcelProperty(value = "客户ID")
    private Long customerId;

    /**
     * 当前余额
     */
    @Schema(description = "当前余额")
    @ExcelProperty(value = "当前余额")
    private BigDecimal balance;

    /**
     * 币种
     */
    @Schema(description = "币种")
    @ExcelProperty(value = "币种")
    private String currency;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    @ExcelProperty(value = "是否删除（0-否，其他-是）")
    private Long deleted;
}
