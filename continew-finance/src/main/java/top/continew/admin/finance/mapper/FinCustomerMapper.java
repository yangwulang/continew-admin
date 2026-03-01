package top.continew.admin.finance.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.continew.admin.finance.model.entity.FinCustomerDO;
import top.continew.admin.finance.model.resp.FinCustomerResp;
import top.continew.starter.data.mapper.BaseMapper;
import top.continew.starter.extension.crud.model.resp.LabelValueResp;

import java.util.List;

/**
* 财务客户 Mapper
*
* @author Qoder
* @since 2026-02-25 16:11:46
*/
@Mapper
public interface FinCustomerMapper extends BaseMapper<FinCustomerDO> {

    /**
     * 分页查询客户列表（关联用户信息）
     */
    IPage<FinCustomerResp> selectCustomerPage(@Param("page") IPage<FinCustomerDO> page,
                                              @Param(Constants.WRAPPER) Wrapper<FinCustomerDO> wrapper);

    /**
     * 查询客户列表（关联用户信息）
     */
    List<FinCustomerResp> selectCustomerList(@Param(Constants.WRAPPER) Wrapper<FinCustomerDO> wrapper);

    /**
     * 查询客户字典（用于下拉选择）
     */
    List<LabelValueResp> selectCustomerDict();
}
