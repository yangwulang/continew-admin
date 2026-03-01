package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinCustomerAccountDO;
import top.continew.admin.finance.model.query.FinCustomerAccountQuery;
import top.continew.admin.finance.model.req.FinCustomerAccountReq;
import top.continew.admin.finance.model.resp.FinCustomerAccountDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerAccountResp;
import top.continew.starter.data.service.IService;

/**
 * 客户账户业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
public interface FinCustomerAccountService extends BaseService<FinCustomerAccountResp, FinCustomerAccountDetailResp, FinCustomerAccountQuery, FinCustomerAccountReq>, IService<FinCustomerAccountDO> {}
