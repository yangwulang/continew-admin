package top.continew.admin.finance.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinMaterialCategoryQuery;
import top.continew.admin.finance.model.req.FinMaterialCategoryReq;
import top.continew.admin.finance.model.resp.FinMaterialCategoryDetailResp;
import top.continew.admin.finance.model.resp.FinMaterialCategoryResp;
import top.continew.admin.finance.service.FinMaterialCategoryService;

/**
 * 物料分类管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
@Tag(name = "物料分类管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-material-category", api = {
        Api.TREE, Api.CREATE, Api.UPDATE,
        Api.BATCH_DELETE, Api.EXPORT, Api.DICT
})
public class FinMaterialCategoryController extends BaseController<FinMaterialCategoryService,
        FinMaterialCategoryResp, FinMaterialCategoryDetailResp,
        FinMaterialCategoryQuery, FinMaterialCategoryReq> {}
