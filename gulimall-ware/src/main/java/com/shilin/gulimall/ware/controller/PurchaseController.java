package com.shilin.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shilin.gulimall.ware.vo.MergeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shilin.gulimall.ware.entity.PurchaseEntity;
import com.shilin.gulimall.ware.service.PurchaseService;
import com.shilin.common.utils.PageUtils;
import com.shilin.common.utils.R;



/**
 * 采购信息
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-22 11:11:10
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    // /ware/purchase/received
    @PostMapping("/received")
    public R received(@RequestBody List<Long> ids){
        purchaseService.purchaseReceived(ids);
        return R.ok();
    }

    ///ware/purchase/merge
    @PostMapping("/merge")
    public R merge(@RequestBody MergeVo mergeVo){
        purchaseService.purchaseMerge(mergeVo);
        return R.ok();
    }

    // /ware/purchase/unreceive/list
    /**
     * 查询未领取的采购单
     *
     * @param params params
     * @return R
     */
    @GetMapping("/unreceive/list")
    public R purchaseList(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnreceive(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PurchaseEntity purchase){
        purchase.setCreateTime(new Date());
        purchase.setUpdateTime(new Date());
		purchaseService.save(purchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
