package top.continew.admin.finance.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.mapper.FinMaterialCategoryMapper;
import top.continew.admin.finance.model.entity.FinMaterialCategoryDO;
import top.continew.admin.finance.model.query.FinMaterialCategoryQuery;
import top.continew.admin.finance.model.req.FinMaterialCategoryReq;
import top.continew.admin.finance.model.resp.FinMaterialCategoryDetailResp;
import top.continew.admin.finance.model.resp.FinMaterialCategoryResp;
import top.continew.admin.finance.service.FinMaterialCategoryService;

/**
 * 物料分类业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
@Service
@RequiredArgsConstructor
public class FinMaterialCategoryServiceImpl extends BaseServiceImpl<
        FinMaterialCategoryMapper,
        FinMaterialCategoryDO,
        FinMaterialCategoryResp,
        FinMaterialCategoryDetailResp,
        FinMaterialCategoryQuery,
        FinMaterialCategoryReq
        > implements FinMaterialCategoryService {
}
