package top.continew.admin.finance.service;

import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinMaterialCategoryDO;
import top.continew.admin.finance.model.query.FinMaterialCategoryQuery;
import top.continew.admin.finance.model.req.FinMaterialCategoryReq;
import top.continew.admin.finance.model.resp.FinMaterialCategoryDetailResp;
import top.continew.admin.finance.model.resp.FinMaterialCategoryResp;
import top.continew.starter.data.service.IService;

/**
 * 物料分类业务接口
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
public interface FinMaterialCategoryService extends BaseService<FinMaterialCategoryResp, FinMaterialCategoryDetailResp, FinMaterialCategoryQuery, FinMaterialCategoryReq>, IService<FinMaterialCategoryDO> {}
