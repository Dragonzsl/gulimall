package com.shilin.gulimall.product.dao;

import com.shilin.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 18:48:17
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
