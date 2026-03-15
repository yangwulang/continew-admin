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

import java.io.Serial;
import java.io.Serializable;

/**
 * 打印文件上传结果
 *
 * @author AI Generator
 * @since 2026-03-05
 */
@Data
@Schema(description = "打印文件上传结果")
public class PrintFileUploadResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文件访问地址
     */
    @Schema(description = "文件访问地址")
    private String fileUrl;

    /**
     * 原始文件名
     */
    @Schema(description = "原始文件名")
    private String fileName;

    /**
     * 检测到的页数
     */
    @Schema(description = "检测到的页数")
    private Integer pageCount;
}
