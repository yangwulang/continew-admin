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

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.executor.handler.OneToOneAssembleOperationHandler;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;

import top.continew.admin.common.base.model.resp.BaseDetailResp;
import top.continew.admin.common.constant.ContainerConstants;
import java.io.Serial;
import java.math.BigDecimal;

/**
 * 财务客户详情信息
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "财务客户详情信息")
@Assemble(key = "userId", sort = 0, props = {
    @Mapping(src = "username", ref = "name")}, container = ContainerConstants.USER_INFO, handlerType = OneToOneAssembleOperationHandler.class)
public class FinCustomerDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关联用户ID
     */
    @Schema(description = "关联用户ID")
    private Long userId;
    /**
     * 客户名称
     */
    @Schema(description = "客户名称")
    @ExcelProperty(value = "客户名称")
    private String name;

    /**
     * 联系人
     */
    @Schema(description = "联系人")
    @ExcelProperty(value = "联系人")
    private String contact;

    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    @ExcelProperty(value = "联系电话")
    private String contactPhone;

    /**
     * 当前余额
     */
    @Schema(description = "当前余额")
    @ExcelProperty(value = "当前余额")
    private BigDecimal balance;

    /**
     * 是否启用预充值记账
     */
    @Schema(description = "是否启用预充值记账")
    @ExcelProperty(value = "是否启用预充值记账")
    private Boolean enablePrepaid;

    /**
     * 是否允许负余额
     */
    @Schema(description = "是否允许负余额")
    @ExcelProperty(value = "是否允许负余额")
    private Boolean allowNegativeBalance;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    @Schema(description = "是否删除（0-否，其他-是）")
    @ExcelProperty(value = "是否删除（0-否，其他-是）")
    private Long deleted;
}
