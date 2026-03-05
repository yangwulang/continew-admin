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
import top.continew.starter.extension.crud.annotation.DictModel;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * 物料信息实体
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
@Data
@DictModel
@TableName("fin_material")
public class FinMaterialDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 物料名称
     */
    private String name;

    /**
     * 物料编码
     */
    private String code;

    /**
     * 默认单价
     */
    private BigDecimal defaultUnitPrice;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 状态(1-启用,2-禁用)
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
