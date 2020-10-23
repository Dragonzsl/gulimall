package com.shilin.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-22 11:46:00
 */
@Data
public class MergeVo {
//    purchaseId: 1, //整单id
//    items:[1,2,3,4] //合并项集合
    private Long purchaseId;
    private List<Long> items;
}
