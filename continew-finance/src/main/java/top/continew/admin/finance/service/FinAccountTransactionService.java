package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.admin.finance.model.query.FinAccountTransactionQuery;
import top.continew.admin.finance.model.req.FinAccountTransactionReq;
import top.continew.admin.finance.model.req.FinRechargeReq;
import top.continew.admin.finance.model.resp.FinAccountTransactionDetailResp;
import top.continew.admin.finance.model.resp.FinAccountTransactionResp;
import top.continew.starter.data.service.IService;

/**
 * 账户交易业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:11:59
 */
public interface FinAccountTransactionService extends BaseService<FinAccountTransactionResp, FinAccountTransactionDetailResp, FinAccountTransactionQuery, FinAccountTransactionReq>,
    IService<FinAccountTransactionDO> {

    /**
     * 客户充值。
     *
     * @param req 充值参数
     * @return 交易ID
     */
    Long recharge(FinRechargeReq req);
}
