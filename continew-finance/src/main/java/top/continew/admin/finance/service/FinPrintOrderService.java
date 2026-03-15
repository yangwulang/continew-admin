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

package top.continew.admin.finance.service;

import org.springframework.web.multipart.MultipartFile;
import top.continew.admin.common.base.service.BaseService;
import top.continew.admin.finance.model.entity.FinPrintOrderDO;
import top.continew.admin.finance.model.query.FinPrintOrderQuery;
import top.continew.admin.finance.model.req.FinPrintOrderReq;
import top.continew.admin.finance.model.req.PrintOrderCreateReq;
import top.continew.admin.finance.model.req.PrintPriceCalculateReq;
import top.continew.admin.finance.model.resp.FinPrintOrderDetailResp;
import top.continew.admin.finance.model.resp.FinPrintOrderResp;
import top.continew.admin.finance.model.resp.PrintAttributeWithOptionsResp;
import top.continew.admin.finance.model.resp.PrintFileUploadResp;
import top.continew.admin.finance.model.resp.PrintPriceCalculateResp;
import top.continew.starter.data.service.IService;

import java.util.List;

/**
 * 打印订单业务接口
 *
 * @author AI Generator
 * @since 2026-03-05
 */
public interface FinPrintOrderService extends BaseService<FinPrintOrderResp, FinPrintOrderDetailResp, FinPrintOrderQuery, FinPrintOrderReq>, IService<FinPrintOrderDO> {

    /**
     * 上传文件并检测页数
     *
     * @param file 上传的文件(PDF或图片)
     * @return 文件信息和页数
     */
    PrintFileUploadResp uploadAndDetectPages(MultipartFile file);

    /**
     * 计算打印价格
     *
     * @param req 价格计算请求参数
     * @return 价格计算结果
     */
    PrintPriceCalculateResp calculatePrice(PrintPriceCalculateReq req);

    /**
     * 创建打印订单（含自动记账+扣款）
     *
     * @param req 创建请求参数
     * @return 订单ID
     */
    Long createOrder(PrintOrderCreateReq req);

    /**
     * 获取所有启用的打印属性和选项(前端动态渲染用)
     *
     * @return 属性列表(含选项)
     */
    List<PrintAttributeWithOptionsResp> listAttributesWithOptions();
}
