package top.continew.admin.finance.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinBillingItemQuery;
import top.continew.admin.finance.model.req.FinBillingItemReq;
import top.continew.admin.finance.model.resp.FinBillingItemDetailResp;
import top.continew.admin.finance.model.resp.FinBillingItemResp;
import top.continew.admin.finance.service.FinBillingItemService;

/**
 * 记账明细管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:12:26
 */
@Tag(name = "记账明细管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-billing-item", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinBillingItemController extends BaseController<FinBillingItemService, FinBillingItemResp, FinBillingItemDetailResp, FinBillingItemQuery, FinBillingItemReq> {}
