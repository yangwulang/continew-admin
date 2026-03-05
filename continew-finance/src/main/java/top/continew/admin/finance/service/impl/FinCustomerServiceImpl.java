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

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.mapper.FinCustomerMapper;
import top.continew.admin.finance.model.entity.FinCustomerDO;
import top.continew.admin.finance.model.query.FinCustomerQuery;
import top.continew.admin.finance.model.req.FinCustomerReq;
import top.continew.admin.finance.model.resp.FinCustomerDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerResp;
import top.continew.admin.finance.service.FinCustomerService;
import top.continew.admin.system.event.UserCreateEvent;
import top.continew.admin.system.model.entity.user.UserDO;
import top.continew.starter.core.util.SpringUtils;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.query.SortQuery;
import top.continew.starter.extension.crud.model.resp.LabelValueResp;
import top.continew.starter.extension.crud.model.resp.PageResp;

import java.util.List;

/**
 * 财务客户业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
@Service
@RequiredArgsConstructor
public class FinCustomerServiceImpl extends BaseServiceImpl<FinCustomerMapper, FinCustomerDO, FinCustomerResp, FinCustomerDetailResp, FinCustomerQuery, FinCustomerReq> implements FinCustomerService {

    @Override
    public PageResp<FinCustomerResp> page(FinCustomerQuery query, PageQuery pageQuery) {
        QueryWrapper<FinCustomerDO> queryWrapper = buildCustomQueryWrapper(query);
        IPage<FinCustomerResp> page = baseMapper.selectCustomerPage(new Page<>(pageQuery.getPage(), pageQuery
            .getSize()), queryWrapper);
        return PageResp.build(page);
    }

    @Override
    public List<FinCustomerResp> list(FinCustomerQuery query, SortQuery sortQuery) {
        QueryWrapper<FinCustomerDO> queryWrapper = buildCustomQueryWrapper(query);
        return baseMapper.selectCustomerList(queryWrapper);
    }

    @Override
    public List<LabelValueResp> dict(FinCustomerQuery query, SortQuery sortQuery) {
        return baseMapper.selectCustomerDict();
    }

    /**
     * 构建查询条件（支持跨表 username/nickname 模糊搜索）
     */
    private QueryWrapper<FinCustomerDO> buildCustomQueryWrapper(FinCustomerQuery query) {
        QueryWrapper<FinCustomerDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t1.deleted", 0);
        if (query != null && StrUtil.isNotBlank(query.getUsername())) {
            queryWrapper.and(w -> w.like("t2.username", query.getUsername())
                .or()
                .like("t2.nickname", query.getUsername()));
        }
        queryWrapper.orderByDesc("t1.create_time");
        return queryWrapper;
    }

    @EventListener
    public void handleUserCreate(UserCreateEvent event) {
        // 用户已经插入数据库中，此处已经生成ID了
        UserDO user = event.getUser();
        FinCustomerReq req = new FinCustomerReq();
        req.setUserId(user.getId());
        req.setEnablePrepaid(true);
        req.setAllowNegativeBalance(false);
        // 这里是监听器可能存在事务问题，在此处调用代理后的service进行创建
        SpringUtils.getBean(this.getClass(), false).create(req);
    }

}
