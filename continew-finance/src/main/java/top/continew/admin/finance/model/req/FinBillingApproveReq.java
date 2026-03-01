package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 记账记录审核参数
 *
 * @author Qoder
 */
@Data
@Schema(description = "记账记录审核参数")
public class FinBillingApproveReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 是否通过
     */
    @Schema(description = "是否通过")
    @NotNull(message = "是否通过不能为空")
    private Boolean approved;

    /**
     * 审核备注
     */
    @Schema(description = "审核备注")
    @Length(max = 500, message = "审核备注长度不能超过 {max} 个字符")
    private String reviewRemark;
}
