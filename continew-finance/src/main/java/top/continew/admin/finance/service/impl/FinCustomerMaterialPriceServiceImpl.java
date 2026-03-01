package top.continew.admin.finance.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.mapper.FinCustomerMaterialPriceMapper;
import top.continew.admin.finance.model.entity.FinCustomerMaterialPriceDO;
import top.continew.admin.finance.model.query.FinCustomerMaterialPriceQuery;
import top.continew.admin.finance.model.req.FinCustomerMaterialPriceReq;
import top.continew.admin.finance.model.resp.FinCustomerMaterialPriceDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerMaterialPriceResp;
import top.continew.admin.finance.service.FinCustomerMaterialPriceService;

/**
 * 客户物料价格业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:12:15
 */
@Service
@RequiredArgsConstructor
public class FinCustomerMaterialPriceServiceImpl extends BaseServiceImpl<FinCustomerMaterialPriceMapper, FinCustomerMaterialPriceDO, FinCustomerMaterialPriceResp, FinCustomerMaterialPriceDetailResp, FinCustomerMaterialPriceQuery, FinCustomerMaterialPriceReq> implements FinCustomerMaterialPriceService {
}
