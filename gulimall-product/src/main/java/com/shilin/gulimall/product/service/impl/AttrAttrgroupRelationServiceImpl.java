package com.shilin.gulimall.product.service.impl;

import com.shilin.gulimall.product.vo.AttrGroupRelationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shilin.common.utils.PageUtils;
import com.shilin.common.utils.Query;

import com.shilin.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.shilin.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.shilin.gulimall.product.service.AttrAttrgroupRelationService;

import javax.annotation.Resource;


@Service("attrAttrgroupRelationService")
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationDao, AttrAttrgroupRelationEntity> implements AttrAttrgroupRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrAttrgroupRelationEntity> page = this.page(
                new Query<AttrAttrgroupRelationEntity>().getPage(params),
                new QueryWrapper<AttrAttrgroupRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void addAttrRelation(AttrGroupRelationVo[] attrGroupRelationVo) {
        List<AttrAttrgroupRelationEntity> entityList = Arrays.stream(attrGroupRelationVo).map(attr -> {
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            BeanUtils.copyProperties(attr, relationEntity);
            return relationEntity;
        }).collect(Collectors.toList());
        this.saveBatch(entityList);
    }

}
