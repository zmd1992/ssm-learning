package com.ihappy.java.ssmlearning.common.domain;

import com.ihappy.java.ssmlearning.dubbo.annotation.FieldComment;
import com.sun.javafx.image.IntPixelGetter;

/**
 * 分页查询
 */
public class PageQuery extends CommonQuery {
    @FieldComment(value = "默认总项目数")
    private static final Integer defaultTotalItem = new Integer(0);
    @FieldComment(value = "默认第一页")
    private static final Integer defaultFirstPage = new Integer(1);
    @FieldComment(value = "默认页大小")
    private static final Integer defaultPageSize = new Integer(20);
    @FieldComment(value = "总项目数")
    private Integer totalItem;
    @FieldComment(value = "页大小")
    private Integer pageSize;
    @FieldComment(value = "当前页")
    private Integer currentPage;
    @FieldComment(value = "限制条数")
    private Integer limit;
    @FieldComment(value = "起始位置")
    private Integer offset;
    @FieldComment(value = "开始行")
    private Integer startRow;
    @FieldComment(value = "结束行")
    private Integer endRow;
    @FieldComment(value = "开始索引")
    private Integer startIndex;

    public PageQuery() {
    }

    /**
     * 设置当前页
     */
    public void setCurrentPage(Integer currentPage) {
        //如果当前页不等于null且大于0,得到当前页,否则等于null
        if (currentPage != null && currentPage > 0) {
            this.currentPage = currentPage;
        } else {
            this.currentPage = null;
        }
        this.setStartAndEndRow();
    }

    /**
     * 设置开始和结束行
     */
    private void setStartAndEndRow() {
        //开始行=页数大小*（当前页-1）+1
        this.startRow = this.getPageSize() * (this.getCurrentPage() - 1) + 1;
        //开始索引=页数大小*（当前页-1）
        this.startIndex = this.getPageSize() * (this.currentPage - 1);
        //结束行=开始行+页大小-1
        this.endRow = this.startRow + this.getPageSize() - 1;
    }

    /**
     * 得到当前页
     */
    public Integer getCurrentPage() {
        //如果当前页为null，返回默认第一页1，否则返回当前页
        return this.currentPage == null ? defaultFirstPage : this.currentPage;
    }


    @Override
    public void validation() {

    }

    public static Integer getDefaultFirstPage() {
        return defaultFirstPage;
    }

    /**
     * 得到页大小
     *
     * @return
     */
    public Integer getPageSize() {
        //如果页大小等于null，返回默认页大小，否则返回这个页大小
        return this.pageSize == null ? this.getDefaultPageSize() : this.pageSize;
    }

    /**
     * 设置页大小
     *
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        //如果页大小不等于null且大于0，返回这个数，否则返回null,设置页的开始行和结束行
        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = null;
        }
        this.setStartAndEndRow();
    }

    //判断是否是第一页
    public boolean isFirstPage() {
        //返回当前也等于1
        return this.getCurrentPage() == 1;
    }

    /**
     * 得到前一页
     *
     * @return
     */
    public int getPreviousPage() {
        //返回上一页
        int back = this.getCurrentPage() - 1;
        //如果上一页小于等于0，上一页等于1
        if (back <= 0) {
            back = 1;
        }
        return back;
    }

    /**
     * 判断最后一页
     *
     * @return
     */
    public boolean isLastPage() {
        //返回总页=当前页
        return this.getTotalPage() == this.currentPage;
    }

    /**
     * 获得总页
     *
     * @return
     */
    public Integer getTotalPage() {
        //得到页大小
        int pageSize = this.getPageSize();
        //得到总项目数
        int total = this.getTotalItem();
        //得到总页数=总项目数/页大小
        int result = total / pageSize;
        //如果总项目数=0或总项目数/页大小的余数！=0，返回++result
        if (total == 0 || total % pageSize != 0) {
            ++result;
        }
        return result;
    }

    //获得下一页
    public boolean nextPage() {
        //如果当前页不等于null且当前页的大小大于等于总页数,返回 false
        if (this.currentPage != null && this.currentPage >= this.getTotalPage()) {
            return false;
        } else {
            //否则
            //如果当前页等于null，设置当前页为默认第一页
            if (this.currentPage == null) {
                this.setCurrentPage(defaultFirstPage);
            } else {
                //否则，为下一页
                this.setCurrentPage(this.getNextPage());
            }
            return true;
        }

    }

    /**
     * 得到下一页
     *
     * @return
     */
    public Integer getNextPage() {
        //下一页
        int next = this.getCurrentPage() +1;
        //如果上一页大于页总数，上一页=页总数
        if (next > this.getTotalPage()) {
            next = this.getTotalPage();
        }
        return next;
    }

    public Integer getLimit() {

        return limit=limit;
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

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    protected Integer getDefaultPageSize() {
        return defaultPageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    //得到项目总数
    public Integer getTotalItem() {
        //如果总项目数为null返回默认总项目数，否则返回当前总项目数
        return this.totalItem == null ? defaultTotalItem : this.totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }
}
