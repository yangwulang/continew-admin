package top.continew.admin.finance.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinCustomerQuery;
import top.continew.admin.finance.model.req.FinCustomerReq;
import top.continew.admin.finance.model.resp.FinCustomerDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerResp;
import top.continew.admin.finance.service.FinCustomerService;

/**
 * 财务客户管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:11:46
 */
@Tag(name = "财务客户管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-customer", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinCustomerController extends BaseController<FinCustomerService, FinCustomerResp, FinCustomerDetailResp, FinCustomerQuery, FinCustomerReq> {}
