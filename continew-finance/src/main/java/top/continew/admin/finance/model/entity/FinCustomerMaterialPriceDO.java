package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;


import java.io.Serial;
import java.time.*;
import java.math.BigDecimal;

/**
 * 客户物料价格实体
 *
 * @author Qoder
 * @since 2026-02-25 16:12:15
 */
@Data
@TableName("fin_customer_material_price")
public class FinCustomerMaterialPriceDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 物料ID
     */
    private Long materialId;

    /**
     * 专属单价
     */
    private BigDecimal unitPrice;

    /**
     * 生效时间
     */
    private LocalDateTime effectiveFrom;

    /**
     * 失效时间
     */
    private LocalDateTime effectiveTo;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
