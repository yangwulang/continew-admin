/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.finance.controller;

import java.util.List;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import top.continew.starter.extension.crud.enums.Api;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.base.controller.BaseController;
import top.continew.admin.finance.model.query.FinPrintOrderQuery;
import top.continew.admin.finance.model.req.FinPrintOrderReq;
import top.continew.admin.finance.model.req.PrintOrderCreateReq;
import top.continew.admin.finance.model.req.PrintPriceCalculateReq;
import top.continew.admin.finance.model.resp.FinPrintOrderDetailResp;
import top.continew.admin.finance.model.resp.FinPrintOrderResp;
import top.continew.admin.finance.model.resp.PrintAttributeWithOptionsResp;
import top.continew.admin.finance.model.resp.PrintFileUploadResp;
import top.continew.admin.finance.model.resp.PrintPriceCalculateResp;
import top.continew.admin.finance.service.FinPrintOrderService;

/**
 * 打印订单管理 API
 *
 * @author AI Generator
 * @since 2026-03-05
 */
@Tag(name = "打印订单管理 API")
@RestController
@CrudRequestMapping(value = "/finance/fin-print-order", api = {Api.PAGE, Api.GET, Api.BATCH_DELETE, Api.EXPORT})
public class FinPrintOrderController extends BaseController<FinPrintOrderService, FinPrintOrderResp, FinPrintOrderDetailResp, FinPrintOrderQuery, FinPrintOrderReq> {

    @Operation(summary = "上传文件并检测页数", description = "上传PDF或图片文件，自动检测页数")
    @PostMapping("/upload")
    public PrintFileUploadResp upload(@RequestParam("file") MultipartFile file) {
        return baseService.uploadAndDetectPages(file);
    }

    @Operation(summary = "计算打印价格", description = "根据选中的选项、页数和份数计算价格")
    @PostMapping("/calculate")
    public PrintPriceCalculateResp calculate(@RequestBody @Valid PrintPriceCalculateReq req) {
        return baseService.calculatePrice(req);
    }

    @Operation(summary = "创建打印订单", description = "创建打印订单并自动记账扣款")
    @PostMapping("/create")
    public Long createOrder(@RequestBody @Valid PrintOrderCreateReq req) {
        return baseService.createOrder(req);
    }

    @Operation(summary = "获取打印属性和选项", description = "获取所有启用的打印属性及其选项，用于前端动态渲染")
    @GetMapping("/attributes")
    public List<PrintAttributeWithOptionsResp> listAttributes() {
        return baseService.listAttributesWithOptions();
    }
}
