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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import top.continew.admin.finance.service.FinBillingRecordService;
import top.continew.starter.core.util.validation.CheckUtils;
import top.continew.starter.extension.tenant.util.TenantUtils;
import top.continew.starter.web.model.R;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 客户签名公开 API（无需登录）
 *
 * @author generator
 */
@Tag(name = "客户签名公开 API")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/open/sign")
public class FinBillingSignController {

    private final FinBillingRecordService finBillingRecordService;

    @Operation(summary = "根据token获取账单信息")
    @GetMapping("/billing")
    public R<Map<String, Object>> getBillingByToken(@RequestParam @NotBlank(message = "token不能为空") String token,
                                                    @RequestParam @NotNull(message = "租户ID不能为空") Long tenantId) {
        AtomicReference<Map<String, Object>> result = new AtomicReference<>();
        TenantUtils.execute(tenantId, () -> {
            result.set(finBillingRecordService.getBySignToken(token));
        });
        return R.ok(result.get());
    }

    @Operation(summary = "提交签名")
    @PostMapping("/billing")
    public R<Void> submitSign(@RequestParam @NotBlank(message = "token不能为空") String token,
                              @RequestParam @NotNull(message = "租户ID不能为空") Long tenantId,
                              @RequestBody Map<String, String> body,
                              HttpServletRequest request) {
        String signImageData = body.get("signImageData");
        CheckUtils.throwIfBlank(signImageData, "签名数据不能为空");
        String clientIp = getClientIp(request);
        TenantUtils.execute(tenantId, () -> {
            finBillingRecordService.signByToken(token, signImageData, clientIp);
        });
        return R.ok();
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }
}
