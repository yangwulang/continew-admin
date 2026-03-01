package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;
import java.io.Serial;
import java.io.Serializable;

/**
 * 财务客户创建或修改参数
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
@Data
@Schema(description = "财务客户创建或修改参数")
public class FinCustomerReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关联用户ID
     */
    @Schema(description = "关联用户ID")
    @NotNull(message = "关联用户ID不能为空")
    private Long userId;

    /**
     * 是否启用预充值记账
     */
    @Schema(description = "是否启用预充值记账")
    @NotNull(message = "是否启用预充值记账不能为空")
    private Boolean enablePrepaid;

    /**
     * 是否允许负余额
     */
    @Schema(description = "是否允许负余额")
    @NotNull(message = "是否允许负余额不能为空")
    private Boolean allowNegativeBalance;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 500, message = "备注长度不能超过 {max} 个字符")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
