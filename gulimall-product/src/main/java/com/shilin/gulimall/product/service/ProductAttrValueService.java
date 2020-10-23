package com.shilin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shilin.common.utils.PageUtils;
import com.shilin.gulimall.product.entity.ProductAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 18:48:16
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttrValue(List<ProductAttrValueEntity> collect);

    List<ProductAttrValueEntity> getListForSpuBySpuId(Long spuId);

    void updateAttrBySpuId(List<ProductAttrValueEntity> params, Long spuId);
}

