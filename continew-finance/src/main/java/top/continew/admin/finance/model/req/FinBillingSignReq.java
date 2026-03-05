/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
