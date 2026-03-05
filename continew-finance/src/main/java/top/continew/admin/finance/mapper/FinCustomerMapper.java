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

package top.continew.admin.finance.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.continew.admin.finance.model.entity.FinCustomerDO;
import top.continew.admin.finance.model.resp.FinCustomerResp;
import top.continew.starter.data.mapper.BaseMapper;
import top.continew.starter.extension.crud.model.resp.LabelValueResp;

import java.util.List;

/**
 * 财务客户 Mapper
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
@Mapper
public interface FinCustomerMapper extends BaseMapper<FinCustomerDO> {

    /**
     * 分页查询客户列表（关联用户信息）
     */
    IPage<FinCustomerResp> selectCustomerPage(@Param("page") IPage<FinCustomerDO> page,
                                              @Param(Constants.WRAPPER) Wrapper<FinCustomerDO> wrapper);

    /**
     * 查询客户列表（关联用户信息）
     */
    List<FinCustomerResp> selectCustomerList(@Param(Constants.WRAPPER) Wrapper<FinCustomerDO> wrapper);

    /**
     * 查询客户字典（用于下拉选择）
     */
    List<LabelValueResp> selectCustomerDict();
}
