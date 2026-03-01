package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinCustomerMaterialPriceDO;
import top.continew.admin.finance.model.query.FinCustomerMaterialPriceQuery;
import top.continew.admin.finance.model.req.FinCustomerMaterialPriceReq;
import top.continew.admin.finance.model.resp.FinCustomerMaterialPriceDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerMaterialPriceResp;
import top.continew.starter.data.service.IService;

/**
 * 客户物料价格业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:12:15
 */
public interface FinCustomerMaterialPriceService extends BaseService<FinCustomerMaterialPriceResp, FinCustomerMaterialPriceDetailResp, FinCustomerMaterialPriceQuery, FinCustomerMaterialPriceReq>, IService<FinCustomerMaterialPriceDO> {}
