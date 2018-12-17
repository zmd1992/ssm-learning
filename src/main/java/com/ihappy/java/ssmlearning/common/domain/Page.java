package com.ihappy.java.ssmlearning.common.domain;

import com.ihappy.java.ssmlearning.common.domain.dto.ICallRequestBaseQuery;
import com.ihappy.java.ssmlearning.common.util.PageUtils;
import com.ihappy.java.ssmlearning.dubbo.annotation.FieldComment;
import com.ihappy.java.ssmlearning.model.LeavingMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 分页
 *
 * @param <T>
 */
public class Page<T> extends ICallRequestBaseQuery implements Serializable, Iterable<T> {
    @FieldComment(value = "每页限制条数")
    private static final Integer defaultPageLimit=new Integer(20);
    @FieldComment(value = "列表泛型")
    protected List<T> result;
    @FieldComment(value = "页大小")
    protected int pageSize;
    @FieldComment(value = "页数")
    protected int pageNumber;
    @FieldComment(value = "总数")
    protected int total;
    @FieldComment(value = "限制数量")
    private int limit;
    @FieldComment(value = "起始位置")
    private int offset;

    public Page(int pageSize, int pageNumber, int total) {
        this(pageNumber, pageSize, total, (List<T>) new ArrayList<>(0));
    }

    public Page(int pageNumber, int pageSize, int total, List<T> result) {
        //如果页数内容大小小于等于0，抛出非法参数异常：页数大小必须大于0
        if (pageSize <= 0) {
            throw new IllegalArgumentException("[pageSize]must great than zero");
        } else {
            this.pageSize = pageSize;
            this.pageNumber = PageUtils.computePageNumber(pageNumber, pageSize, total);
            this.total = total;
            this.setResult(result);
        }
    }

    public Page() {

    }

    /**
     * 取得选择记录的初始位置
     */
    public int getStartPos(){
        return (getCurrentPage()-1)*pageSize;
    }

    //设置结果
    public void setResult(List<T> elements) {
        //如果元素等于null，报异常：结果不能为null
        if (elements == null) {
            throw new IllegalArgumentException("'result' must be not null");
        } else {
            this.result = elements;
        }
    }

    /**
     * 迭代
     *
     * @return
     */
    public Iterator<T> iterator() {
        //如果结果等于null，集合空列表迭代，否则返回这个结果迭代
        return this.result == null ? (Iterator<T>) Collections.emptyList().iterator() : this.result.iterator();
    }

    public List<T> getResult() {
        return result;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit=defaultPageLimit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
