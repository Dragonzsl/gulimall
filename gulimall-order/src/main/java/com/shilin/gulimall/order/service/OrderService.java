package com.shilin.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shilin.common.utils.PageUtils;
import com.shilin.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-08 18:11:33
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

