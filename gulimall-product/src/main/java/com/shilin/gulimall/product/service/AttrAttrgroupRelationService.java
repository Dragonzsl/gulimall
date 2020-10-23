package com.shilin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shilin.common.utils.PageUtils;
import com.shilin.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.shilin.gulimall.product.vo.AttrGroupRelationVo;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 18:48:16
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addAttrRelation(AttrGroupRelationVo[] attrGroupRelationVo);
}

