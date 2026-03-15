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

package top.continew.admin.finance.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.base.model.resp.BaseResp;
import java.io.Serial;

/**
 * 打印属性信息
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:30
 */
@Data
@Schema(description = "打印属性信息")
public class FinPrintAttributeResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 属性名称
     */
    @Schema(description = "属性名称")
    private String name;

    /**
     * 属性编码
     */
    @Schema(description = "属性编码")
    private String code;

    /**
     * 输入类型(SELECT-单选/MULTI_SELECT-多选)
     */
    @Schema(description = "输入类型(SELECT-单选/MULTI_SELECT-多选)")
    private String inputType;

    /**
     * 是否必选
     */
    @Schema(description = "是否必选")
    private Boolean isRequired;

    /**
     * 排序号
     */
    @Schema(description = "排序号")
    private Integer sort;

    /**
     * 状态(1-启用, 2-禁用)
     */
    @Schema(description = "状态(1-启用, 2-禁用)")
    private Integer status;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    private Long deleted;
}
