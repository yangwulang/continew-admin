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
import java.math.BigDecimal;

/**
 * 客户地址创建或修改参数
 *
 * @author generator
 * @since 2026-03-01 21:11:17
 */
@Data
@Schema(description = "客户地址创建或修改参数")
public class FinCustomerAddressReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @Schema(description = "客户ID")
    @NotNull(message = "客户ID不能为空")
    private Long customerId;

    /**
     * 联系人姓名
     */
    @Schema(description = "联系人姓名")
    @NotBlank(message = "联系人姓名不能为空")
    @Length(max = 50, message = "联系人姓名长度不能超过 {max} 个字符")
    private String contactName;

    /**
     * 联系人电话
     */
    @Schema(description = "联系人电话")
    @NotBlank(message = "联系人电话不能为空")
    @Length(max = 20, message = "联系人电话长度不能超过 {max} 个字符")
    private String contactPhone;

    /**
     * 省份
     */
    @Schema(description = "省份")
    @NotBlank(message = "省份不能为空")
    @Length(max = 50, message = "省份长度不能超过 {max} 个字符")
    private String province;

    /**
     * 城市
     */
    @Schema(description = "城市")
    @NotBlank(message = "城市不能为空")
    @Length(max = 50, message = "城市长度不能超过 {max} 个字符")
    private String city;

    /**
     * 区/县
     */
    @Schema(description = "区/县")
    @NotBlank(message = "区/县不能为空")
    @Length(max = 50, message = "区/县长度不能超过 {max} 个字符")
    private String district;

    /**
     * 详细地址
     */
    @Schema(description = "详细地址")
    @NotBlank(message = "详细地址不能为空")
    @Length(max = 255, message = "详细地址长度不能超过 {max} 个字符")
    private String detailAddress;

    /**
     * 经度
     */
    @Schema(description = "经度")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @Schema(description = "纬度")
    private BigDecimal latitude;

    /**
     * 是否默认地址
     */
    @Schema(description = "是否默认地址")
    @NotNull(message = "是否默认地址不能为空")
    private Boolean isDefault;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 500, message = "备注长度不能超过 {max} 个字符")
    private String remark;
}
