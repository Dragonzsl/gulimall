package com.shilin.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shilin.common.utils.PageUtils;
import com.shilin.common.utils.Query;
import com.shilin.gulimall.product.dao.AttrGroupDao;
import com.shilin.gulimall.product.entity.AttrEntity;
import com.shilin.gulimall.product.entity.AttrGroupEntity;
import com.shilin.gulimall.product.service.AttrGroupService;
import com.shilin.gulimall.product.service.AttrService;
import com.shilin.gulimall.product.vo.AttrGroupWithAttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {

        //select * from pms_attr_group where catelog_id = ? and (attr_group_id = ? or attr_group_name like %key%);
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((obj) -> obj.eq("attr_group_id", key)
                    .or()
                    .like("attr_group_name", key));
        }
        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
            return new PageUtils(page);
        } else {
            wrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
            return new PageUtils(page);
        }
    }

    @Override
    public List<AttrGroupWithAttrVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));

        return attrGroupEntities.stream().map(attrGroupEntity -> {
            AttrGroupWithAttrVo attrGroupWithAttrVo = new AttrGroupWithAttrVo();
            BeanUtils.copyProperties(attrGroupEntity, attrGroupWithAttrVo);
            List<AttrEntity> attrEntities = attrService.getAttrRelation(attrGroupWithAttrVo.getAttrGroupId());
            attrGroupWithAttrVo.setAttrs(attrEntities);
            return attrGroupWithAttrVo;
        }).collect(Collectors.toList());
    }

}
