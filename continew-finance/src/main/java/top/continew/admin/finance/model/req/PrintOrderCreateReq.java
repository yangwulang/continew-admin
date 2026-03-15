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

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 打印订单创建请求参数（多文件）
 *
 * @author AI Generator
 * @since 2026-03-05
 */
@Data
@Schema(description = "打印订单创建请求参数")
public class PrintOrderCreateReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 文件项列表
     */
    @Schema(description = "文件项列表")
    @NotEmpty(message = "至少需要一个打印文件")
    @Valid
    private List<PrintOrderItemReq> items;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 文件项请求参数
     */
    @Data
    @Schema(description = "打印订单文件项")
    public static class PrintOrderItemReq implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * 上传文件地址
         */
        @Schema(description = "上传文件地址")
        @NotNull(message = "文件地址不能为空")
        private String fileUrl;

        /**
         * 原始文件名
         */
        @Schema(description = "原始文件名")
        private String fileName;

        /**
         * 文件页数
         */
        @Schema(description = "文件页数")
        @NotNull(message = "文件页数不能为空")
        @Min(value = 1, message = "文件页数至少为1")
        private Integer pageCount;

        /**
         * 打印份数
         */
        @Schema(description = "打印份数")
        @NotNull(message = "打印份数不能为空")
        @Min(value = 1, message = "打印份数至少为1")
        private Integer copies;

        /**
         * 选中的属性选项ID列表
         */
        @Schema(description = "选中的属性选项ID列表")
        @NotEmpty(message = "请至少选择一个打印选项")
        private List<Long> optionIds;
    }
}
