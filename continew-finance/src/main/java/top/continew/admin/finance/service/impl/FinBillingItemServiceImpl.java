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

package top.continew.admin.finance.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.mapper.FinBillingItemMapper;
import top.continew.admin.finance.model.entity.FinBillingItemDO;
import top.continew.admin.finance.model.query.FinBillingItemQuery;
import top.continew.admin.finance.model.req.FinBillingItemReq;
import top.continew.admin.finance.model.resp.FinBillingItemDetailResp;
import top.continew.admin.finance.model.resp.FinBillingItemResp;
import top.continew.admin.finance.service.FinBillingItemService;

/**
 * 记账明细业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:12:26
 */
@Service
@RequiredArgsConstructor
public class FinBillingItemServiceImpl extends BaseServiceImpl<FinBillingItemMapper, FinBillingItemDO, FinBillingItemResp, FinBillingItemDetailResp, FinBillingItemQuery, FinBillingItemReq> implements FinBillingItemService {
}
