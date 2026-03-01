package top.continew.admin.finance.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.finance.model.entity.FinMaterialDO;
import top.continew.starter.data.mapper.BaseMapper;

/**
* 物料信息 Mapper
*
* @author Qoder
* @since 2026-02-25 16:12:11
*/
@Mapper
public interface FinMaterialMapper extends BaseMapper<FinMaterialDO> {
}
