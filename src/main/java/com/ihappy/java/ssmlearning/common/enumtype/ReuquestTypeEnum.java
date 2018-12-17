package com.ihappy.java.ssmlearning.common.enumtype;

import com.konglong.dubbo.annotation.FieldComment;

/**
 * 请求类型枚举
 * http:hypertext transfer protocol WWW 服务程序所用的协议
 * service:服务
 */
public enum ReuquestTypeEnum {
    HTTP("0", "http"),
    SERVICE("1","service");

    @FieldComment(value = "类型")
    private String type;
    @FieldComment(value = "降序")
    private String desc;

    ReuquestTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    ReuquestTypeEnum(String type) {
        this.type = type;
    }

    /**
     * 获得枚举
     *
     * @param type
     * @return
     */
    public static ReuquestTypeEnum getRequestTypeEnum(String type) {
        //获得枚举值
        ReuquestTypeEnum[] var1 = values();
        //获得枚举值的长度
        int var2 = var1.length;
        //循环枚举值的长度
        for (int var3 = 0; var3 < var2; ++var3) {
            //请求类型枚举的值var3
            ReuquestTypeEnum x = var1[var3];
            //如果值等于某类型,返回值
            if (x.getType().equals(type)) {
                return x;
            }
        }
        return null;
    }
}
