package com.shilin.gulimall.product.feign;

import com.shilin.common.to.SkuReductionTo;
import com.shilin.common.to.SpuBoundsTo;
import com.shilin.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-21 16:32:26
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @PostMapping("/coupon/spubounds/save")
    R save(@RequestBody SpuBoundsTo spuBoundsTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
