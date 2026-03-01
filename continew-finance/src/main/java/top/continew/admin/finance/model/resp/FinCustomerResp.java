package top.continew.admin.finance.model.resp;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.executor.handler.OneToOneAssembleOperationHandler;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.base.model.resp.BaseResp;
import top.continew.admin.common.constant.ContainerConstants;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * 财务客户信息
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
@Data
@Schema(description = "财务客户信息")
@Assemble(key = "userId", sort = 0,
        props = {
                @Mapping(src = "username", ref = "username"),
                @Mapping(src = "nickname", ref = "nickname"),
                @Mapping(src = "phone", ref = "phone"),
                @Mapping(src = "email", ref = "email"),
        },
        container = ContainerConstants.USER_INFO,
        handlerType = OneToOneAssembleOperationHandler.class
)
public class FinCustomerResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关联用户ID
     */
    @Schema(description = "关联用户ID")
    private Long userId;
    /**
     * 当前余额
     */
    @Schema(description = "当前余额")
    private BigDecimal balance;
    /**
     * 用户名（来自sys_user）
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 昵称（来自sys_user）
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 手机号（来自sys_user）
     */
    @Schema(description = "手机号")
    private String phone;

    /**
     * 邮箱（来自sys_user）
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 是否启用预充值记账
     */
    @Schema(description = "是否启用预充值记账")
    private Boolean enablePrepaid;

    /**
     * 是否允许负余额
     */
    @Schema(description = "是否允许负余额")
    private Boolean allowNegativeBalance;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
