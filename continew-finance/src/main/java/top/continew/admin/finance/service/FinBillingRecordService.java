package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinBillingRecordDO;
import top.continew.admin.finance.model.query.FinBillingRecordQuery;
import top.continew.admin.finance.model.req.FinBillingApproveReq;
import top.continew.admin.finance.model.req.FinBillingCreateReq;
import top.continew.admin.finance.model.req.FinBillingRecordReq;
import top.continew.admin.finance.model.req.FinBillingSignReq;
import top.continew.admin.finance.model.resp.FinBillingRecordDetailResp;
import top.continew.admin.finance.model.resp.FinBillingRecordResp;
import top.continew.starter.data.service.IService;

/**
 * 记账记录业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
public interface FinBillingRecordService extends BaseService<FinBillingRecordResp, FinBillingRecordDetailResp, FinBillingRecordQuery, FinBillingRecordReq>,
    IService<FinBillingRecordDO> {

    /**
     * 创建记账记录及明细，状态默认为 DRAFT。
     *
     * @param req 创建参数
     * @return 记录ID
     */
    Long createWithItems(FinBillingCreateReq req);

    /**
     * 为指定记账记录生成签名链接，并返回签名访问URL。
     *
     * @param id 记录ID
     * @return 签名访问URL
     */
    String generateSignLink(Long id);

    /**
     * 记录客户签名信息，将状态置为 PENDING_REVIEW。
     *
     * @param id  记录ID
     * @param req 签名参数
     */
    void sign(Long id, FinBillingSignReq req);

    /**
     * 审核记账记录；通过时根据配置自动扣减预充值余额。
     *
     * @param id  记录ID
     * @param req 审核参数
     */
    void approve(Long id, FinBillingApproveReq req);
}
