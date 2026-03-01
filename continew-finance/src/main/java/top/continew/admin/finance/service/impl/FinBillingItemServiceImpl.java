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
