package top.continew.admin.finance.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.continew.admin.common.base.service.BaseServiceImpl;
import top.continew.admin.common.context.UserContextHolder;
import top.continew.starter.core.util.validation.CheckUtils;
import top.continew.admin.finance.mapper.FinAccountTransactionMapper;
import top.continew.admin.finance.mapper.FinBillingItemMapper;
import top.continew.admin.finance.mapper.FinBillingRecordMapper;
import top.continew.admin.finance.mapper.FinCustomerAccountMapper;
import top.continew.admin.finance.mapper.FinCustomerMapper;
import top.continew.admin.finance.mapper.FinCustomerMaterialPriceMapper;
import top.continew.admin.finance.mapper.FinMaterialMapper;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.admin.finance.model.entity.FinBillingItemDO;
import top.continew.admin.finance.model.entity.FinBillingRecordDO;
import top.continew.admin.finance.model.entity.FinCustomerAccountDO;
import top.continew.admin.finance.model.entity.FinCustomerDO;
import top.continew.admin.finance.model.entity.FinCustomerMaterialPriceDO;
import top.continew.admin.finance.model.entity.FinMaterialDO;
import top.continew.admin.finance.model.query.FinBillingRecordQuery;
import top.continew.admin.finance.model.req.FinBillingApproveReq;
import top.continew.admin.finance.model.req.FinBillingCreateItemReq;
import top.continew.admin.finance.model.req.FinBillingCreateReq;
import top.continew.admin.finance.model.req.FinBillingRecordReq;
import top.continew.admin.finance.model.req.FinBillingSignReq;
import top.continew.admin.finance.model.resp.FinBillingRecordDetailResp;
import top.continew.admin.finance.model.resp.FinBillingRecordResp;
import top.continew.admin.finance.service.FinBillingRecordService;

/**
 * 记账记录业务实现
 *
 * @author Qoder
 * @since 2026-02-25 16:12:22
 */
@Service
@RequiredArgsConstructor
public class FinBillingRecordServiceImpl extends BaseServiceImpl<FinBillingRecordMapper, FinBillingRecordDO, FinBillingRecordResp, FinBillingRecordDetailResp, FinBillingRecordQuery, FinBillingRecordReq>
    implements FinBillingRecordService {

    private static final String STATUS_DRAFT = "DRAFT";
    private static final String STATUS_PENDING_SIGN = "PENDING_SIGN";
    private static final String STATUS_PENDING_REVIEW = "PENDING_REVIEW";
    private static final String STATUS_CONFIRMED = "CONFIRMED";
    private static final String STATUS_REJECTED = "REJECTED";

    private final FinBillingItemMapper finBillingItemMapper;
    private final FinMaterialMapper finMaterialMapper;
    private final FinCustomerMaterialPriceMapper finCustomerMaterialPriceMapper;
    private final FinCustomerMapper finCustomerMapper;
    private final FinCustomerAccountMapper finCustomerAccountMapper;
    private final FinAccountTransactionMapper finAccountTransactionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createWithItems(FinBillingCreateReq req) {
        CheckUtils.throwIf(req == null, "请求参数不能为空");
        List<FinBillingCreateItemReq> items = req.getItems();
        CheckUtils.throwIf(CollUtil.isEmpty(items), "记账明细不能为空");

        BigDecimal totalAmount = BigDecimal.ZERO;
        LocalDateTime now = LocalDateTime.now();
        List<FinBillingItemDO> itemDOList = new ArrayList<>(items.size());

        for (FinBillingCreateItemReq itemReq : items) {
            Long materialId = itemReq.getMaterialId();
            FinMaterialDO material = finMaterialMapper.selectById(materialId);
            CheckUtils.throwIfNull(material, "物料不存在");

            BigDecimal quantity = itemReq.getQuantity();
            CheckUtils.throwIf(quantity == null || quantity.compareTo(BigDecimal.ZERO) <= 0, "数量必须大于 0");

            BigDecimal unitPrice = itemReq.getUnitPrice();
            if (unitPrice == null) {
                unitPrice = this.resolveUnitPrice(req.getCustomerId(), material, now);
            }
            BigDecimal amount = unitPrice.multiply(quantity);

            FinBillingItemDO itemDO = new FinBillingItemDO();
            itemDO.setMaterialId(materialId);
            itemDO.setMaterialName(material.getName());
            itemDO.setUnitPrice(unitPrice);
            itemDO.setQuantity(quantity);
            itemDO.setAmount(amount);
            itemDO.setRemark(itemReq.getRemark());
            itemDOList.add(itemDO);

            totalAmount = totalAmount.add(amount);
        }

        FinBillingRecordReq recordReq = new FinBillingRecordReq();
        recordReq.setCustomerId(req.getCustomerId());
        recordReq.setBillingDate(req.getBillingDate());
        recordReq.setTotalAmount(totalAmount);
        recordReq.setStatus(STATUS_DRAFT);

        Long recordId = super.create(recordReq);
        itemDOList.forEach(item -> item.setBillingRecordId(recordId));
        finBillingItemMapper.insertBatch(itemDOList);

        return recordId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String generateSignLink(Long id) {
        FinBillingRecordDO record = super.getById(id);
        CheckUtils.throwIfNull(record, "记账记录不存在");
        CheckUtils.throwIf(STATUS_CONFIRMED.equals(record.getStatus()), "已生效的记账记录不允许重新生成签名链接");

        String token = IdUtil.fastSimpleUUID();
        String signUrl = "/finance/sign/billing?token=" + token;

        record.setSignLinkToken(token);
        record.setSignUrl(signUrl);
        record.setStatus(STATUS_PENDING_SIGN);
        baseMapper.updateById(record);
        return signUrl;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sign(Long id, FinBillingSignReq req) {
        FinBillingRecordDO record = super.getById(id);
        CheckUtils.throwIfNull(record, "记账记录不存在");
        CheckUtils.throwIf(!STATUS_PENDING_SIGN.equals(record.getStatus()), "当前状态不允许签名");

        record.setSignImageUrl(req.getSignImageUrl());
        record.setSignClientIp(req.getSignClientIp());
        record.setSignedAt(LocalDateTime.now());
        record.setStatus(STATUS_PENDING_REVIEW);
        baseMapper.updateById(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void approve(Long id, FinBillingApproveReq req) {
        FinBillingRecordDO record = super.getById(id);
        CheckUtils.throwIfNull(record, "记账记录不存在");
        CheckUtils.throwIf(!STATUS_PENDING_REVIEW.equals(record.getStatus()), "当前状态不允许审核");

        record.setReviewedAt(LocalDateTime.now());
        record.setReviewRemark(req.getReviewRemark());
        record.setReviewedBy(UserContextHolder.getUserId());

        if (Boolean.FALSE.equals(req.getApproved())) {
            record.setStatus(STATUS_REJECTED);
            baseMapper.updateById(record);
            return;
        }

        Long customerId = record.getCustomerId();
        FinCustomerDO customer = finCustomerMapper.selectById(customerId);
        CheckUtils.throwIfNull(customer, "客户不存在");

        if (Boolean.TRUE.equals(customer.getEnablePrepaid())) {
            FinCustomerAccountDO account = finCustomerAccountMapper.lambdaQuery()
                .eq(FinCustomerAccountDO::getCustomerId, customerId)
                .one();
            CheckUtils.throwIfNull(account, "客户账户不存在，请先充值");

            BigDecimal balance = account.getBalance() == null ? BigDecimal.ZERO : account.getBalance();
            BigDecimal totalAmount = record.getTotalAmount();
            if (!Boolean.TRUE.equals(customer.getAllowNegativeBalance())) {
                CheckUtils.throwIf(balance.compareTo(totalAmount) < 0, "客户余额不足，无法完成扣费");
            }
            BigDecimal newBalance = balance.subtract(totalAmount);

            account.setBalance(newBalance);
            finCustomerAccountMapper.updateById(account);

            FinAccountTransactionDO tx = new FinAccountTransactionDO();
            tx.setCustomerId(customerId);
            tx.setType("DEBIT_BILLING");
            tx.setDirection("OUT");
            tx.setAmount(totalAmount);
            tx.setBalanceAfter(newBalance);
            tx.setBillingRecordId(id);
            tx.setChannel("BALANCE");
            tx.setStatus("CONFIRMED");
            tx.setOccurTime(LocalDateTime.now());
            tx.setRemark("记账扣费");
            finAccountTransactionMapper.insert(tx);
        }

        record.setStatus(STATUS_CONFIRMED);
        baseMapper.updateById(record);
    }

    private BigDecimal resolveUnitPrice(Long customerId, FinMaterialDO material, LocalDateTime now) {
        BigDecimal price = finCustomerMaterialPriceMapper.lambdaQuery()
            .eq(FinCustomerMaterialPriceDO::getCustomerId, customerId)
            .eq(FinCustomerMaterialPriceDO::getMaterialId, material.getId())
            .le(FinCustomerMaterialPriceDO::getEffectiveFrom, now)
            .and(wrapper -> wrapper.ge(FinCustomerMaterialPriceDO::getEffectiveTo, now)
                .or()
                .isNull(FinCustomerMaterialPriceDO::getEffectiveTo))
            .orderByDesc(FinCustomerMaterialPriceDO::getEffectiveFrom)
            .oneOpt()
            .map(FinCustomerMaterialPriceDO::getUnitPrice)
            .orElse(null);
        if (price != null) {
            return price;
        }
        return material.getDefaultUnitPrice();
    }
}
