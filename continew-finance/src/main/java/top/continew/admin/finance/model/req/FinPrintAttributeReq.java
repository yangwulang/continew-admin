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

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;
import java.io.Serial;
import java.io.Serializable;

/**
 * 打印属性创建或修改参数
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:30
 */
@Data
@Schema(description = "打印属性创建或修改参数")
public class FinPrintAttributeReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 属性名称
     */
    @Schema(description = "属性名称")
    @NotBlank(message = "属性名称不能为空")
    @Length(max = 50, message = "属性名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 属性编码
     */
    @Schema(description = "属性编码")
    @NotBlank(message = "属性编码不能为空")
    @Length(max = 50, message = "属性编码长度不能超过 {max} 个字符")
    private String code;

    /**
     * 输入类型(SELECT-单选/MULTI_SELECT-多选)
     */
    @Schema(description = "输入类型(SELECT-单选/MULTI_SELECT-多选)")
    @NotBlank(message = "输入类型(SELECT-单选/MULTI_SELECT-多选)不能为空")
    @Length(max = 20, message = "输入类型(SELECT-单选/MULTI_SELECT-多选)长度不能超过 {max} 个字符")
    private String inputType;

    /**
     * 是否必选
     */
    @Schema(description = "是否必选")
    @NotNull(message = "是否必选不能为空")
    private Boolean isRequired;

    /**
     * 排序号
     */
    @Schema(description = "排序号")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    /**
     * 状态(1-启用, 2-禁用)
     */
    @Schema(description = "状态(1-启用, 2-禁用)")
    @NotNull(message = "状态(1-启用, 2-禁用)不能为空")
    private Integer status;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
