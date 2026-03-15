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

package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;

import java.io.Serial;

/**
 * 打印属性实体
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:30
 */
@Data
@TableName("fin_print_attribute")
public class FinPrintAttributeDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性编码
     */
    private String code;

    /**
     * 输入类型(SELECT-单选/MULTI_SELECT-多选)
     */
    private String inputType;

    /**
     * 是否必选
     */
    private Boolean isRequired;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 状态(1-启用, 2-禁用)
     */
    private Integer status;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
