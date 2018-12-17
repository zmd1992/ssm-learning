package com.ihappy.java.ssmlearning.common.util;

import java.util.UUID;

/**
 * uuid:在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的。
 */
public class UUIDUtil {
    public UUIDUtil() {
    }
    //得到UUID
    public static String getUUID(boolean isFormat){
        //如果isFormat格式化是true ，UUID是随机的并且转换成字符串,否则转换成字符串后用-替换所有的空字符
        return isFormat? UUID.randomUUID().toString():UUID.randomUUID().toString().replaceAll("-","");
    }
}
