package top.continew.admin.finance.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * 客户账户查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
@Data
@Schema(description = "客户账户查询条件")
public class FinCustomerAccountQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
