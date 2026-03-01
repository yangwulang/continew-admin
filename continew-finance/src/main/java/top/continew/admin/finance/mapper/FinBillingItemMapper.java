package top.continew.admin.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.finance.model.entity.FinBillingItemDO;
import top.continew.starter.data.mapper.BaseMapper;

/**
* 记账明细 Mapper
*
* @author Qoder
* @since 2026-02-25 16:12:26
*/
@Mapper
public interface FinBillingItemMapper extends BaseMapper<FinBillingItemDO> {
}
