package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;


import java.io.Serial;
import java.math.BigDecimal;

/**
 * 客户账户实体
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
@Data
@TableName("fin_customer_account")
public class FinCustomerAccountDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 当前余额
     */
    private BigDecimal balance;

    /**
     * 币种
     */
    private String currency;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
