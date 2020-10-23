package com.shilin.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shilin.common.utils.PageUtils;
import com.shilin.gulimall.ware.entity.PurchaseEntity;
import com.shilin.gulimall.ware.vo.MergeVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-22 11:11:10
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceive(Map<String, Object> params);

    void purchaseMerge(MergeVo mergeVo);

    void purchaseReceived(List<Long> ids);
}

