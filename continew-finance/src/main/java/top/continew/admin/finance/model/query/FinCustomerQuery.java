package top.continew.admin.finance.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * 财务客户查询条件
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
@Data
@Schema(description = "财务客户查询条件")
public class FinCustomerQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户名（关联sys_user.username，模糊搜索）
     */
    @Schema(description = "用户名")
    private String username;
}
