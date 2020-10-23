package com.shilin.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.shilin.gulimall.product.entity.ProductAttrValueEntity;
import com.shilin.gulimall.product.service.ProductAttrValueService;
import com.shilin.gulimall.product.vo.AttrRespVo;
import com.shilin.gulimall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shilin.gulimall.product.entity.AttrEntity;
import com.shilin.gulimall.product.service.AttrService;
import com.shilin.common.utils.PageUtils;
import com.shilin.common.utils.R;



/**
 * 商品属性
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 18:48:16
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    // /product/attr/base/listforspu/{spuId}

    /**
     * 获取spu规格
     *
     * @param spuId spuId
     * @return R
     */
    @GetMapping("/base/listforspu/{spuId}")
    public R listforspu(@PathVariable("spuId") Long spuId){
        List<ProductAttrValueEntity> list = productAttrValueService.getListForSpuBySpuId(spuId);
        return R.ok().put("data", list);
    }

    // /product/attr/base/list/{catelogId}
    /**
     * 获取分类规格参数
     *
     * @param params 请求参数
     * @param catelogId catelogId
     * @return R
     */
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseList(@RequestParam Map<String, Object> params,
                      @PathVariable("catelogId") Long catelogId,
                      @PathVariable("attrType") String attrType){
        PageUtils page = attrService.querybaseListPage(params,catelogId,attrType);

        return R.ok().put("page", page);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);
        AttrRespVo attrRespVo = attrService.getInfo(attrId);
        return R.ok().put("attr", attrRespVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return R.ok();
    }

    // /product/attr/update/{spuId}

    /**
     * 修改商品规格
     *
     * @param params params
     * @param spuId spuId
     * @return R
     */
    @PostMapping("/update/{spuId}")
    public R updateAttr(@RequestBody List<ProductAttrValueEntity> params,
                        @PathVariable("spuId") Long spuId){
        productAttrValueService.updateAttrBySpuId(params,spuId);
        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
