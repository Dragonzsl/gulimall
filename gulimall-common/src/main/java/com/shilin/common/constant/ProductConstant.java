package com.shilin.common.constant;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-19 13:18:29
 */
public class ProductConstant {

    public enum AttrEnum {
        ATTR_TYPE_BASE(1, "基本属性"),
        ATTR_TYPE_SALE(0, "销售属性");
        private final int code;
        private final String msg;

        AttrEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }


        public String getMsg() {
            return msg;
        }
    }
}
