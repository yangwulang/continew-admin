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

package top.continew.admin.finance.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.dromara.x.file.storage.core.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.system.service.FileService;
import top.continew.starter.core.util.validation.CheckUtils;
import top.continew.admin.finance.mapper.FinAccountTransactionMapper;
import top.continew.admin.finance.mapper.FinBillingItemMapper;
import top.continew.admin.finance.mapper.FinBillingRecordMapper;
import top.continew.admin.finance.mapper.FinCustomerAccountMapper;
import top.continew.admin.finance.mapper.FinCustomerMapper;
import top.continew.admin.finance.mapper.FinPrintAttributeMapper;
import top.continew.admin.finance.mapper.FinPrintAttributeOptionMapper;
import top.continew.admin.finance.mapper.FinPrintOrderItemMapper;
import top.continew.admin.finance.mapper.FinPrintOrderMapper;
import top.continew.admin.finance.mapper.FinPrintOrderOptionMapper;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.admin.finance.model.entity.FinBillingItemDO;
import top.continew.admin.finance.model.entity.FinBillingRecordDO;
import top.continew.admin.finance.model.entity.FinCustomerAccountDO;
import top.continew.admin.finance.model.entity.FinCustomerDO;
import top.continew.admin.finance.model.entity.FinPrintAttributeDO;
import top.continew.admin.finance.model.entity.FinPrintAttributeOptionDO;
import top.continew.admin.finance.model.entity.FinPrintOrderDO;
import top.continew.admin.finance.model.entity.FinPrintOrderItemDO;
import top.continew.admin.finance.model.entity.FinPrintOrderOptionDO;
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
 * 打印订单业务实现
 *
 * @author AI Generator
 * @since 2026-03-05
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FinPrintOrderServiceImpl extends BaseServiceImpl<FinPrintOrderMapper, FinPrintOrderDO, FinPrintOrderResp, FinPrintOrderDetailResp, FinPrintOrderQuery, FinPrintOrderReq> implements FinPrintOrderService {

    private static final String PRICE_MODE_PER_PAGE = "PER_PAGE";
    private static final String PRICE_MODE_FIXED = "FIXED";
    private static final String PRICE_MODE_MULTIPLIER = "MULTIPLIER";

    private static final Set<String> IMAGE_EXTENSIONS = Set.of("jpg", "jpeg", "png", "gif", "bmp", "webp", "tiff");
    private static final DateTimeFormatter ORDER_NO_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private final FinPrintAttributeMapper printAttributeMapper;
    private final FinPrintAttributeOptionMapper printAttributeOptionMapper;
    private final FinPrintOrderItemMapper printOrderItemMapper;
    private final FinPrintOrderOptionMapper printOrderOptionMapper;
    private final FinBillingRecordMapper billingRecordMapper;
    private final FinBillingItemMapper billingItemMapper;
    private final FinCustomerMapper customerMapper;
    private final FinCustomerAccountMapper customerAccountMapper;
    private final FinAccountTransactionMapper accountTransactionMapper;
    private final FileService fileService;

    @Override
    public PrintFileUploadResp uploadAndDetectPages(MultipartFile file) {
        CheckUtils.throwIfNull(file, "请上传文件");
        String originalFilename = file.getOriginalFilename();
        CheckUtils.throwIfBlank(originalFilename, "文件名不能为空");

        String extension = getFileExtension(originalFilename).toLowerCase();
        boolean isPdf = "pdf".equals(extension);
        boolean isImage = IMAGE_EXTENSIONS.contains(extension);
        CheckUtils.throwIf(!isPdf && !isImage, "仅支持 PDF 和图片文件(JPG/PNG/GIF/BMP/WEBP)");

        // 检测页数
        int pageCount;
        if (isPdf) {
            pageCount = detectPdfPageCount(file);
        } else {
            pageCount = 1;
        }

        // 上传文件
        FileInfo fileInfo;
        try {
            fileInfo = fileService.upload(file, "/print/");
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败", e);
        }

        PrintFileUploadResp resp = new PrintFileUploadResp();
        resp.setFileUrl(fileInfo.getUrl());
        resp.setFileName(originalFilename);
        resp.setPageCount(pageCount);
        return resp;
    }

    @Override
    public PrintPriceCalculateResp calculatePrice(PrintPriceCalculateReq req) {
        BigDecimal orderTotal = BigDecimal.ZERO;
        List<PrintPriceCalculateResp.ItemPriceResult> itemResults = new ArrayList<>();

        for (PrintPriceCalculateReq.PrintPriceItemReq itemReq : req.getItems()) {
            List<FinPrintAttributeOptionDO> options = printAttributeOptionMapper.selectByIds(itemReq.getOptionIds());
            CheckUtils.throwIf(CollUtil.isEmpty(options), "打印选项不存在");

            PrintPriceCalculateResp.ItemPriceResult itemResult = doCalculatePrice(options, itemReq
                .getPageCount(), itemReq.getCopies());
            itemResult.setFileName(itemReq.getFileName());
            itemResults.add(itemResult);
            orderTotal = orderTotal.add(itemResult.getSubtotalAmount());
        }

        PrintPriceCalculateResp resp = new PrintPriceCalculateResp();
        resp.setTotalAmount(orderTotal);
        resp.setItems(itemResults);
        return resp;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createOrder(PrintOrderCreateReq req) {
        // 1. 校验客户
        FinCustomerDO customer = customerMapper.selectById(req.getCustomerId());
        CheckUtils.throwIfNull(customer, "客户不存在");

        // 2. 生成订单编号
        String orderNo = "PO" + LocalDateTime.now().format(ORDER_NO_FORMAT) + IdUtil.fastSimpleUUID()
            .substring(0, 6)
            .toUpperCase();

        // 3. 创建打印订单（先插入，金额后面更新）
        FinPrintOrderDO order = new FinPrintOrderDO();
        order.setOrderNo(orderNo);
        order.setCustomerId(req.getCustomerId());
        order.setTotalAmount(BigDecimal.ZERO);
        order.setStatus("CONFIRMED");
        order.setRemark(req.getRemark());
        baseMapper.insert(order);

        // 4. 逐个创建文件项 + 选项快照
        BigDecimal orderTotal = BigDecimal.ZERO;
        List<PrintPriceCalculateResp.ItemPriceResult> allItemResults = new ArrayList<>();

        for (int i = 0; i < req.getItems().size(); i++) {
            PrintOrderCreateReq.PrintOrderItemReq itemReq = req.getItems().get(i);

            // 查询选项
            List<FinPrintAttributeOptionDO> options = printAttributeOptionMapper.selectByIds(itemReq.getOptionIds());
            CheckUtils.throwIf(CollUtil.isEmpty(options), "打印选项不存在");

            // 计算该项价格
            PrintPriceCalculateResp.ItemPriceResult priceResult = doCalculatePrice(options, itemReq
                .getPageCount(), itemReq.getCopies());
            priceResult.setFileName(itemReq.getFileName());
            allItemResults.add(priceResult);

            // 创建订单项
            FinPrintOrderItemDO item = new FinPrintOrderItemDO();
            item.setOrderId(order.getId());
            item.setFileUrl(itemReq.getFileUrl());
            item.setFileName(itemReq.getFileName());
            item.setPageCount(itemReq.getPageCount());
            item.setCopies(itemReq.getCopies());
            item.setSubtotalAmount(priceResult.getSubtotalAmount());
            item.setSort(i);
            printOrderItemMapper.insert(item);

            // 保存选项快照
            saveItemOptions(item.getId(), options, priceResult);
            orderTotal = orderTotal.add(priceResult.getSubtotalAmount());
        }

        // 5. 更新订单总金额
        order.setTotalAmount(orderTotal);
        baseMapper.updateById(order);

        // 6. 自动创建记账记录
        Long billingRecordId = createBillingRecord(customer, order, allItemResults);
        order.setBillingRecordId(billingRecordId);
        baseMapper.updateById(order);

        // 7. 自动扣款
        processDeduction(customer, order, billingRecordId);

        return order.getId();
    }

    @Override
    public List<PrintAttributeWithOptionsResp> listAttributesWithOptions() {
        // 查询所有启用的属性
        List<FinPrintAttributeDO> attributes = printAttributeMapper.lambdaQuery()
            .eq(FinPrintAttributeDO::getStatus, 1)
            .eq(FinPrintAttributeDO::getDeleted, 0)
            .orderByAsc(FinPrintAttributeDO::getSort)
            .list();

        if (CollUtil.isEmpty(attributes)) {
            return new ArrayList<>();
        }

        // 查询所有启用的选项
        List<Long> attrIds = attributes.stream().map(FinPrintAttributeDO::getId).collect(Collectors.toList());
        List<FinPrintAttributeOptionDO> allOptions = printAttributeOptionMapper.lambdaQuery()
            .in(FinPrintAttributeOptionDO::getAttributeId, attrIds)
            .eq(FinPrintAttributeOptionDO::getStatus, 1)
            .eq(FinPrintAttributeOptionDO::getDeleted, 0)
            .orderByAsc(FinPrintAttributeOptionDO::getSort)
            .list();

        // 组装返回数据
        return attributes.stream().map(attr -> {
            PrintAttributeWithOptionsResp resp = new PrintAttributeWithOptionsResp();
            resp.setId(attr.getId());
            resp.setName(attr.getName());
            resp.setCode(attr.getCode());
            resp.setInputType(attr.getInputType());
            resp.setIsRequired(attr.getIsRequired());
            resp.setSort(attr.getSort());

            List<PrintAttributeWithOptionsResp.OptionItem> optionItems = allOptions.stream()
                .filter(opt -> attr.getId().equals(opt.getAttributeId()))
                .map(opt -> {
                    PrintAttributeWithOptionsResp.OptionItem item = new PrintAttributeWithOptionsResp.OptionItem();
                    item.setId(opt.getId());
                    item.setName(opt.getName());
                    item.setCode(opt.getCode());
                    item.setPriceMode(opt.getPriceMode());
                    item.setPrice(opt.getPrice());
                    item.setIsDefault(opt.getIsDefault());
                    item.setSort(opt.getSort());
                    return item;
                })
                .collect(Collectors.toList());
            resp.setOptions(optionItems);
            return resp;
        }).collect(Collectors.toList());
    }

    // ==================== 私有方法 ====================

    /**
     * 价格计算核心逻辑（单个文件项）
     */
    private PrintPriceCalculateResp.ItemPriceResult doCalculatePrice(List<FinPrintAttributeOptionDO> options,
                                                                     int pageCount,
                                                                     int copies) {
        // 查询属性名称
        List<Long> attrIds = options.stream()
            .map(FinPrintAttributeOptionDO::getAttributeId)
            .distinct()
            .collect(Collectors.toList());
        List<FinPrintAttributeDO> attributes = printAttributeMapper.selectByIds(attrIds);
        java.util.Map<Long, String> attrNameMap = attributes.stream()
            .collect(Collectors.toMap(FinPrintAttributeDO::getId, FinPrintAttributeDO::getName));

        BigDecimal perPageSum = BigDecimal.ZERO;
        BigDecimal fixedSum = BigDecimal.ZERO;
        BigDecimal multiplierProduct = BigDecimal.ONE;

        List<PrintPriceCalculateResp.PriceDetail> details = new ArrayList<>();

        for (FinPrintAttributeOptionDO option : options) {
            PrintPriceCalculateResp.PriceDetail detail = new PrintPriceCalculateResp.PriceDetail();
            detail.setAttributeName(attrNameMap.getOrDefault(option.getAttributeId(), ""));
            detail.setOptionName(option.getName());
            detail.setPriceMode(option.getPriceMode());
            detail.setPrice(option.getPrice());

            switch (option.getPriceMode()) {
                case PRICE_MODE_PER_PAGE:
                    perPageSum = perPageSum.add(option.getPrice());
                    BigDecimal perPageAmount = option.getPrice().multiply(BigDecimal.valueOf(pageCount));
                    detail.setCalculatedAmount(perPageAmount);
                    break;
                case PRICE_MODE_FIXED:
                    fixedSum = fixedSum.add(option.getPrice());
                    detail.setCalculatedAmount(option.getPrice());
                    break;
                case PRICE_MODE_MULTIPLIER:
                    multiplierProduct = multiplierProduct.multiply(option.getPrice());
                    detail.setCalculatedAmount(BigDecimal.ZERO);
                    break;
                default:
                    break;
            }
            details.add(detail);
        }

        BigDecimal pageCost = perPageSum.multiply(BigDecimal.valueOf(pageCount));
        BigDecimal multipliedCost = pageCost.multiply(multiplierProduct).setScale(2, RoundingMode.HALF_UP);
        BigDecimal subtotalAmount = multipliedCost.add(fixedSum)
            .multiply(BigDecimal.valueOf(copies))
            .setScale(2, RoundingMode.HALF_UP);

        PrintPriceCalculateResp.ItemPriceResult result = new PrintPriceCalculateResp.ItemPriceResult();
        result.setPerPageSum(perPageSum);
        result.setPageCost(pageCost);
        result.setMultipliedCost(multipliedCost);
        result.setFixedSum(fixedSum);
        result.setSubtotalAmount(subtotalAmount);
        result.setDetails(details);
        return result;
    }

    /**
     * 保存订单项选项快照
     */
    private void saveItemOptions(Long itemId,
                                 List<FinPrintAttributeOptionDO> options,
                                 PrintPriceCalculateResp.ItemPriceResult priceResult) {
        List<FinPrintOrderOptionDO> orderOptions = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            FinPrintAttributeOptionDO option = options.get(i);
            PrintPriceCalculateResp.PriceDetail detail = priceResult.getDetails().get(i);

            FinPrintOrderOptionDO orderOption = new FinPrintOrderOptionDO();
            orderOption.setItemId(itemId);
            orderOption.setAttributeId(option.getAttributeId());
            orderOption.setAttributeName(detail.getAttributeName());
            orderOption.setOptionId(option.getId());
            orderOption.setOptionName(option.getName());
            orderOption.setPriceMode(option.getPriceMode());
            orderOption.setPrice(option.getPrice());
            orderOption.setCalculatedAmount(detail.getCalculatedAmount());
            orderOptions.add(orderOption);
        }
        printOrderOptionMapper.insertBatch(orderOptions);
    }

    /**
     * 创建记账记录（多文件项）
     */
    private Long createBillingRecord(FinCustomerDO customer,
                                     FinPrintOrderDO order,
                                     List<PrintPriceCalculateResp.ItemPriceResult> itemResults) {
        // 创建记账主表
        FinBillingRecordDO record = new FinBillingRecordDO();
        record.setCustomerId(customer.getId());
        record.setBillingDate(LocalDate.now());
        record.setTotalAmount(order.getTotalAmount());
        record.setStatus("CONFIRMED");
        billingRecordMapper.insert(record);

        // 创建记账明细（遍历所有文件项的明细）
        List<FinBillingItemDO> items = new ArrayList<>();
        for (PrintPriceCalculateResp.ItemPriceResult itemResult : itemResults) {
            String filePrefix = StrUtil.isNotBlank(itemResult.getFileName())
                ? "[" + itemResult.getFileName() + "] "
                : "";
            for (PrintPriceCalculateResp.PriceDetail detail : itemResult.getDetails()) {
                FinBillingItemDO item = new FinBillingItemDO();
                item.setBillingRecordId(record.getId());
                item.setMaterialName(filePrefix + "打印-" + detail.getAttributeName() + ": " + detail.getOptionName());
                item.setUnitPrice(detail.getPrice());
                item.setQuantity(BigDecimal.ONE);
                item.setAmount(detail.getCalculatedAmount());
                item.setRemark("[打印订单" + order.getOrderNo() + "] " + detail.getPriceMode());
                items.add(item);
            }
        }
        if (CollUtil.isNotEmpty(items)) {
            billingItemMapper.insertBatch(items);
        }

        return record.getId();
    }

    /**
     * 处理自动扣款
     */
    private void processDeduction(FinCustomerDO customer, FinPrintOrderDO order, Long billingRecordId) {
        if (!Boolean.TRUE.equals(customer.getEnablePrepaid())) {
            return;
        }

        FinCustomerAccountDO account = customerAccountMapper.lambdaQuery()
            .eq(FinCustomerAccountDO::getCustomerId, customer.getId())
            .one();
        CheckUtils.throwIfNull(account, "客户账户不存在，请先充值");

        BigDecimal balance = account.getBalance() == null ? BigDecimal.ZERO : account.getBalance();
        BigDecimal totalAmount = order.getTotalAmount();

        if (!Boolean.TRUE.equals(customer.getAllowNegativeBalance())) {
            CheckUtils.throwIf(balance.compareTo(totalAmount) < 0, "客户余额不足，无法完成扣费");
        }

        BigDecimal newBalance = balance.subtract(totalAmount);
        account.setBalance(newBalance);
        customerAccountMapper.updateById(account);

        // 创建交易流水
        FinAccountTransactionDO tx = new FinAccountTransactionDO();
        tx.setCustomerId(customer.getId());
        tx.setType("DEBIT_PRINT");
        tx.setDirection("OUT");
        tx.setAmount(totalAmount);
        tx.setBalanceAfter(newBalance);
        tx.setBillingRecordId(billingRecordId);
        tx.setChannel("BALANCE");
        tx.setStatus("CONFIRMED");
        tx.setOccurTime(LocalDateTime.now());
        tx.setRemark("打印订单扣费: " + order.getOrderNo());
        accountTransactionMapper.insert(tx);
    }

    /**
     * PDF 页数检测
     */
    private int detectPdfPageCount(MultipartFile file) {
        try (PDDocument document = Loader.loadPDF(file.getInputStream().readAllBytes())) {
            return document.getNumberOfPages();
        } catch (Exception e) {
            log.error("检测PDF页数失败", e);
            throw new RuntimeException("PDF文件解析失败，请检查文件是否损坏");
        }
    }

    /**
     * 获取文件扩展名
     */
    private String getFileExtension(String fileName) {
        if (StrUtil.isBlank(fileName) || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
