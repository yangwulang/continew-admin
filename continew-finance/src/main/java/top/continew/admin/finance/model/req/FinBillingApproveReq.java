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
