package top.continew.admin.finance.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.mapper.FinCustomerAccountMapper;
import top.continew.admin.finance.model.entity.FinCustomerAccountDO;
import top.continew.admin.finance.model.query.FinCustomerAccountQuery;
import top.continew.admin.finance.model.req.FinCustomerAccountReq;
import top.continew.admin.finance.model.resp.FinCustomerAccountDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerAccountResp;
import top.continew.admin.finance.service.FinCustomerAccountService;

/**
 * 客户账户业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
@Service
@RequiredArgsConstructor
public class FinCustomerAccountServiceImpl extends BaseServiceImpl<FinCustomerAccountMapper, FinCustomerAccountDO, FinCustomerAccountResp, FinCustomerAccountDetailResp, FinCustomerAccountQuery, FinCustomerAccountReq> implements FinCustomerAccountService {
}
