package com.ihappy.java.ssmlearning.model;

import com.ihappy.java.ssmlearning.common.domain.dto.ICallRequestBaseQuery;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class LeavingMessage extends ICallRequestBaseQuery {
    /**
     * id 编号
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 留言时间
     */
    private Date leavingTime;
    /**
     * 留言人
     */
    private String leavingMan;

    /**
     *是否删除 0 未删除 1删除 默认0
     * @return
     */
    private Integer isDeleted;

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(Date leavingTime) {
        this.leavingTime = leavingTime;
    }

    public String getLeavingMan() {
        return leavingMan;
    }

    public void setLeavingMan(String leavingMan) {
        this.leavingMan = leavingMan;
    }
}
