package com.shilin.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-21 16:54:52
 */
@Data
public class SkuReductionTo {

    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}
