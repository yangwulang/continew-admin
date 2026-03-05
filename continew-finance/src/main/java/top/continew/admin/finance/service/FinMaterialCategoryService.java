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

package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinMaterialCategoryDO;
import top.continew.admin.finance.model.query.FinMaterialCategoryQuery;
import top.continew.admin.finance.model.req.FinMaterialCategoryReq;
import top.continew.admin.finance.model.resp.FinMaterialCategoryDetailResp;
import top.continew.admin.finance.model.resp.FinMaterialCategoryResp;
import top.continew.starter.data.service.IService;

/**
 * 物料分类业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
public interface FinMaterialCategoryService extends BaseService<FinMaterialCategoryResp, FinMaterialCategoryDetailResp, FinMaterialCategoryQuery, FinMaterialCategoryReq>, IService<FinMaterialCategoryDO> {}
