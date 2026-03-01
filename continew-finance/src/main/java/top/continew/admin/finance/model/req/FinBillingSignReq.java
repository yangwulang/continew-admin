package top.continew.admin.finance.model.req;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 记账记录签名参数
 *
 * @author Qoder
 */
@Data
@Schema(description = "记账记录签名参数")
public class FinBillingSignReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 签名图片地址
     */
    @Schema(description = "签名图片地址")
    @NotBlank(message = "签名图片地址不能为空")
    @Length(max = 255, message = "签名图片地址长度不能超过 {max} 个字符")
    private String signImageUrl;

    /**
     * 签名IP
     */
    @Schema(description = "签名IP")
    @Length(max = 50, message = "签名IP长度不能超过 {max} 个字符")
    private String signClientIp;
}
