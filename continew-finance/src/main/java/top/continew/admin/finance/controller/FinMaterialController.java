package top.continew.admin.finance.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinMaterialQuery;
import top.continew.admin.finance.model.req.FinMaterialReq;
import top.continew.admin.finance.model.resp.FinMaterialDetailResp;
import top.continew.admin.finance.model.resp.FinMaterialResp;
import top.continew.admin.finance.service.FinMaterialService;

/**
 * 物料信息管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
@Tag(name = "物料信息管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-material", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinMaterialController extends BaseController<FinMaterialService, FinMaterialResp, FinMaterialDetailResp, FinMaterialQuery, FinMaterialReq> {}
