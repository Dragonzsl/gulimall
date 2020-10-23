package com.shilin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shilin.common.utils.PageUtils;
import com.shilin.gulimall.product.entity.AttrEntity;
import com.shilin.gulimall.product.vo.AttrGroupRelationVo;
import com.shilin.gulimall.product.vo.AttrRespVo;
import com.shilin.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 18:48:16
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils querybaseListPage(Map<String, Object> params, Long catelogId, String attrType);

    AttrRespVo getInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getAttrRelation(Long attrgroupId);

    void deleteAttrRelation(AttrGroupRelationVo[] attrGroupRelationVo);

    PageUtils getNoAttrRelation(Map<String, Object> params, Long attrgroupId);
}

