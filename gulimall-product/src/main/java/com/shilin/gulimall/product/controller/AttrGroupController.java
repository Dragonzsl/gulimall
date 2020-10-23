package com.shilin.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.shilin.gulimall.product.entity.AttrEntity;
import com.shilin.gulimall.product.service.AttrAttrgroupRelationService;
import com.shilin.gulimall.product.service.AttrService;
import com.shilin.gulimall.product.service.CategoryService;
import com.shilin.gulimall.product.vo.AttrGroupRelationVo;
import com.shilin.gulimall.product.vo.AttrGroupWithAttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shilin.gulimall.product.entity.AttrGroupEntity;
import com.shilin.gulimall.product.service.AttrGroupService;
import com.shilin.common.utils.PageUtils;
import com.shilin.common.utils.R;



/**
 * 属性分组
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 18:48:16
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrAttrgroupRelationService relationService;

    // /product/attrgroup/{catelogId}/withattr

    /**
     * 获取分类下所有分组&关联属性
     *
     * @param catelogId 分类ID
     * @return R
     */
    @GetMapping("/{catelogId}/withattr")
    public R getAttrgroupWithattr(@PathVariable("catelogId") Long catelogId){
        List<AttrGroupWithAttrVo> attrGroupWithAttrVoList = attrGroupService.getAttrGroupWithAttrsByCatelogId(catelogId);
        return R.ok().put("data", attrGroupWithAttrVoList);
    }

    // /product/attrgroup/attr/relation
    /**
     * 添加属性与分组关联关系
     *
     * @param attrGroupRelationVo attrGroupRelationVo
     * @return R
     */
    @PostMapping("/attr/relation")
    public R addAttrRelation(@RequestBody AttrGroupRelationVo[] attrGroupRelationVo){
        relationService.addAttrRelation(attrGroupRelationVo);
        return R.ok();
    }

    // /product/attrgroup/{attrgroupId}/noattr/relation
    /**
     * 获取属性分组没有关联的其他属性
     *
     * @param attrgroupId 属性分组ID
     * @param params 请求参数
     * @return R
     */
    @GetMapping("/{attrgroupId}/noattr/relation")
    public R attrNoRelation(@PathVariable("attrgroupId") Long attrgroupId,
                            @RequestParam Map<String, Object> params){
        PageUtils page = attrService.getNoAttrRelation(params,attrgroupId);
        return R.ok().put("page", page);
    }

    // /product/attrgroup/attr/relation/delete
    //{"attrId":1,"attrGroupId":2}
    /**
     * 删除属性与分组的关联关系
     *
     * @param attrGroupRelationVo attrGroupRelationVo
     * @return R
     */
    @PostMapping("/attr/relation/delete")
    public R deleteAttrRelation(@RequestBody AttrGroupRelationVo[] attrGroupRelationVo){
        attrService.deleteAttrRelation(attrGroupRelationVo);
        return R.ok();
    }

    // /product/attrgroup/{attrgroupId}/attr/relation
    /**
     * 获取属性分组的关联的所有属性
     *
     * @param attrgroupId 属性分组ID
     * @return R
     */
    @GetMapping("/{attrgroupId}/attr/relation")
    public R attrRelation(@PathVariable("attrgroupId") Long attrgroupId){
        List<AttrEntity> list = attrService.getAttrRelation(attrgroupId);
        return R.ok().put("data", list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    public R list(@RequestParam Map<String, Object> params,@PathVariable("catelogId") Long catelogId){
//        PageUtils page = attrGroupService.queryPage(params);
        PageUtils page = attrGroupService.queryPage(params,catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] catelogPath = categoryService.findCatelogPath(catelogId);
        attrGroup.setCatelogPath(catelogPath);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
