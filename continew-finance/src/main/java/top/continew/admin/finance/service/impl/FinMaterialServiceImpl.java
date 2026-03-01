package top.continew.admin.finance.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.finance.mapper.FinMaterialMapper;
import top.continew.admin.finance.model.entity.FinMaterialDO;
import top.continew.admin.finance.model.query.FinMaterialQuery;
import top.continew.admin.finance.model.req.FinMaterialReq;
import top.continew.admin.finance.model.resp.FinMaterialDetailResp;
import top.continew.admin.finance.model.resp.FinMaterialResp;
import top.continew.admin.finance.service.FinMaterialService;

/**
 * 物料信息业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
@Service
@RequiredArgsConstructor
public class FinMaterialServiceImpl extends BaseServiceImpl<FinMaterialMapper, FinMaterialDO, FinMaterialResp, FinMaterialDetailResp, FinMaterialQuery, FinMaterialReq> implements FinMaterialService {
}
