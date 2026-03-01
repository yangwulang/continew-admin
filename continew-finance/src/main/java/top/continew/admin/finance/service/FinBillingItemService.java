package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinBillingItemDO;
import top.continew.admin.finance.model.query.FinBillingItemQuery;
import top.continew.admin.finance.model.req.FinBillingItemReq;
import top.continew.admin.finance.model.resp.FinBillingItemDetailResp;
import top.continew.admin.finance.model.resp.FinBillingItemResp;
import top.continew.starter.data.service.IService;

/**
 * 记账明细业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:12:26
 */
public interface FinBillingItemService extends BaseService<FinBillingItemResp, FinBillingItemDetailResp, FinBillingItemQuery, FinBillingItemReq>, IService<FinBillingItemDO> {}
