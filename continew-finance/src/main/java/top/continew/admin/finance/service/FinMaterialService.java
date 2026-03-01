package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinMaterialDO;
import top.continew.admin.finance.model.query.FinMaterialQuery;
import top.continew.admin.finance.model.req.FinMaterialReq;
import top.continew.admin.finance.model.resp.FinMaterialDetailResp;
import top.continew.admin.finance.model.resp.FinMaterialResp;
import top.continew.starter.data.service.IService;

/**
 * 物料信息业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
public interface FinMaterialService extends BaseService<FinMaterialResp, FinMaterialDetailResp, FinMaterialQuery, FinMaterialReq>, IService<FinMaterialDO> {}
