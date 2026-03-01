package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;
import top.continew.starter.extension.crud.annotation.DictModel;


import java.io.Serial;
import java.math.BigDecimal;

/**
 * 物料信息实体
 *
 * @author Qoder
 * @since 2026-02-25 16:12:11
 */
@Data
@DictModel
@TableName("fin_material")
public class FinMaterialDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 物料名称
     */
    private String name;

    /**
     * 物料编码
     */
    private String code;

    /**
     * 默认单价
     */
    private BigDecimal defaultUnitPrice;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 状态(1-启用,2-禁用)
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除（0-否，其他-是）
     */
    private Long deleted;
}
