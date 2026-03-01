package top.continew.admin.finance.controller;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinBillingRecordQuery;
import top.continew.admin.finance.model.req.FinBillingApproveReq;
import top.continew.admin.finance.model.req.FinBillingCreateReq;
import top.continew.admin.finance.model.req.FinBillingRecordReq;
import top.continew.admin.finance.model.req.FinBillingSignReq;
import top.continew.admin.finance.model.resp.FinBillingRecordDetailResp;
import top.continew.admin.finance.model.resp.FinBillingRecordResp;
import top.continew.admin.finance.service.FinBillingRecordService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 记账记录管理 API
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Tag(name = "记账记录管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-billing-record", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.BATCH_DELETE, Api.EXPORT, Api.DICT})
public class FinBillingRecordController extends BaseController<FinBillingRecordService, FinBillingRecordResp, FinBillingRecordDetailResp, FinBillingRecordQuery, FinBillingRecordReq> {

    @Operation(summary = "创建记账记录（含明细）", description = "创建记账记录并自动计算金额")
    @PostMapping("/with-items")
    public Long createWithItems(@RequestBody @Valid FinBillingCreateReq req) {
        return baseService.createWithItems(req);
    }

    @Operation(summary = "生成签名链接", description = "为指定记账记录生成签名链接")
    @PostMapping("/{id}/sign-link")
    public String generateSignLink(@PathVariable Long id) {
        return baseService.generateSignLink(id);
    }

    @Operation(summary = "签名确认", description = "保存客户签名信息")
    @PostMapping("/{id}/sign")
    public void sign(@PathVariable Long id, @RequestBody @Valid FinBillingSignReq req) {
        baseService.sign(id, req);
    }

    @Operation(summary = "审核记账记录", description = "审核记账记录并在通过时执行余额扣减")
    @PostMapping("/{id}/approve")
    public void approve(@PathVariable Long id, @RequestBody @Valid FinBillingApproveReq req) {
        baseService.approve(id, req);
    }
}
