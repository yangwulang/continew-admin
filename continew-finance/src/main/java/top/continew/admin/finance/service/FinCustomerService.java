package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinCustomerDO;
import top.continew.admin.finance.model.query.FinCustomerQuery;
import top.continew.admin.finance.model.req.FinCustomerReq;
import top.continew.admin.finance.model.resp.FinCustomerDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerResp;
import top.continew.starter.data.service.IService;

/**
 * 财务客户业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
public interface FinCustomerService extends BaseService<FinCustomerResp, FinCustomerDetailResp, FinCustomerQuery, FinCustomerReq>, IService<FinCustomerDO> {}
