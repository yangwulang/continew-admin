package top.continew.admin.finance.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinCustomerMaterialPriceQuery;
import top.continew.admin.finance.model.req.FinCustomerMaterialPriceReq;
import top.continew.admin.finance.model.resp.FinCustomerMaterialPriceDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerMaterialPriceResp;
import top.continew.admin.finance.service.FinCustomerMaterialPriceService;

/**
 * 客户物料价格管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:12:15
 */
@Tag(name = "客户物料价格管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-customer-material-price", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinCustomerMaterialPriceController extends BaseController<FinCustomerMaterialPriceService, FinCustomerMaterialPriceResp, FinCustomerMaterialPriceDetailResp, FinCustomerMaterialPriceQuery, FinCustomerMaterialPriceReq> {}
