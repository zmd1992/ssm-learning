package com.ihappy.java.ssmlearning.common.util;

public class PageUtils {
    /**
     * 计算页数
     */
    public static int computePageNumber(int pageNumber, int pageSize, int totalElements) {
        //如果页数小于等于1 返回
        if (pageNumber <= 1) {
            return 1;
        } else {
            //否则页数与最后计算的页数如果不等于2147483647，返回页数，否则返回最后计算的页数
            return 2147483647 != pageNumber && pageNumber <=computeLastPageNumber(totalElements,pageSize)
                    ?pageNumber:computeLastPageNumber(totalElements,pageSize);
        }
    }

    /**
     * 计算最后的页数
     */
    public static int computeLastPageNumber(int totalElements, int pageSize) {
        //总元素/页大小的余数是否等于0，如果等于0，返回总元素/页大小，否则如果余数不等于0，返回总元素/页大小+1
        int result = totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1;
        //如果结果小于等于1 返回1
        if (result <= 1) {
            result = 1;
        }
        return result;
    }
}
