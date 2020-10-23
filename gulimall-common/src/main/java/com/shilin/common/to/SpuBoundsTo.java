package com.shilin.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-21 16:45:10
 */
@Data
public class SpuBoundsTo {

    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
