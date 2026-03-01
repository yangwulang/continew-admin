package top.continew.admin.finance.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.base.model.entity.TenantBaseDO;
import top.continew.starter.extension.crud.annotation.DictModel;


import java.io.Serial;

/**
 * 物料分类实体
 *
 * @author Qoder
 * @since 2026-02-25 16:12:05
 */
@Data
@DictModel
@TableName("fin_material_category")
public class FinMaterialCategoryDO extends TenantBaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 父分类ID
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 树路径
     */
    private String treePath;

    /**
     * 排序
     */
    private Integer sort;

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
