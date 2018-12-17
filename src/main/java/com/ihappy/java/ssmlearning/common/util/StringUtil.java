package com.ihappy.java.ssmlearning.common.util;

public class StringUtil {
    /**
     * 判断是否字符串是否为空
     */
    public static boolean isBlank(String string) {
        //定义一个长度
        int length;
        //如果字符串不等于null且字符串的长度不等于0
        if (string != null && (length = string.length()) != 0) {
            //循环字符串的长度
            for (int i = 0; i < length; i++) {
                //如果字符串的字符位置不是空白  返回false
                if (!Character.isWhitespace(string.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
    /**
     * 判断字符串如果不为空
     */
    public static boolean isNotBlank(String str){
        int length;
        //如果字符串不等于null且字符串的长度等于0
        if (str!=null && (length =str.length())!=0){
            //循环字符串长度
            for (int i=0;i<length;++i) {
                //如果字符不是空字符 ,返回true
                if (!Character.isWhitespace(str.charAt(i))) {
                        return true;
                }
            }
            return false;
        }else{
            return false;
        }

    }
}
