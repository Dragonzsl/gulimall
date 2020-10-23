package com.shilin.gulimall.product.vo;

import lombok.Data;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-18 17:47:38
 */
@Data
public class AttrRespVo extends AttrVo {
    //    "catelogName": "手机/数码/手机", //所属分类名字
//            "groupName": "主体", //所属分组名字
    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
