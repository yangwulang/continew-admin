package top.continew.admin.finance.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinCustomerAccountQuery;
import top.continew.admin.finance.model.req.FinCustomerAccountReq;
import top.continew.admin.finance.model.resp.FinCustomerAccountDetailResp;
import top.continew.admin.finance.model.resp.FinCustomerAccountResp;
import top.continew.admin.finance.service.FinCustomerAccountService;

/**
 * 客户账户管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:11:51
 */
@Tag(name = "客户账户管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-customer-account", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinCustomerAccountController extends BaseController<FinCustomerAccountService, FinCustomerAccountResp, FinCustomerAccountDetailResp, FinCustomerAccountQuery, FinCustomerAccountReq> {}
