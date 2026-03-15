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
import top.continew.admin.finance.mapper.FinPrintOrderOptionMapper;
import top.continew.admin.finance.model.entity.FinPrintOrderOptionDO;
import top.continew.admin.finance.model.query.FinPrintOrderOptionQuery;
import top.continew.admin.finance.model.req.FinPrintOrderOptionReq;
import top.continew.admin.finance.model.resp.FinPrintOrderOptionDetailResp;
import top.continew.admin.finance.model.resp.FinPrintOrderOptionResp;
import top.continew.admin.finance.service.FinPrintOrderOptionService;

/**
 * 打印订单选项业务实现
 *
 * @author AI Generator
 * @since 2026-03-05 19:15:49
 */
@Service
@RequiredArgsConstructor
public class FinPrintOrderOptionServiceImpl extends BaseServiceImpl<FinPrintOrderOptionMapper, FinPrintOrderOptionDO, FinPrintOrderOptionResp, FinPrintOrderOptionDetailResp, FinPrintOrderOptionQuery, FinPrintOrderOptionReq> implements FinPrintOrderOptionService {
}
