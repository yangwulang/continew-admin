package top.continew.admin.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.finance.model.entity.FinBillingRecordDO;
import top.continew.starter.data.mapper.BaseMapper;

/**
* 记账记录 Mapper
*
* @author Qoder
* @since 2026-02-25 16:12:22
*/
@Mapper
public interface FinBillingRecordMapper extends BaseMapper<FinBillingRecordDO> {
}
