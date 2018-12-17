package com.ihappy.java.ssmlearning.bo;

import com.ihappy.java.ssmlearning.dubbo.annotation.FieldComment;

public class QueryLeavingMessageBO {
    @FieldComment(value = "限制条数")
    private Integer limit;
    @FieldComment(value = "起始位置")
    private Integer offset;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
