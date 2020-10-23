package com.shilin.gulimall.product.vo;

import com.shilin.gulimall.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-20 18:43:00
 */
@Data
public class AttrGroupWithAttrVo {
    public static final long serialVersionUID = 9080093673785711227L;
    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    private List<AttrEntity> attrs;
}
