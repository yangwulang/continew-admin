package top.continew.admin.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.starter.data.mapper.BaseMapper;

/**
* 账户交易 Mapper
*
* @author Qoder
* @since 2026-02-25 16:11:59
*/
@Mapper
public interface FinAccountTransactionMapper extends BaseMapper<FinAccountTransactionDO> {
}
