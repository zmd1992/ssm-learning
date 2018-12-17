package com.ihappy.java.ssmlearning.model;

import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

public class ReplyMessage {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 回复内容
     */
    private String replyContent;
    /**
     * 回复时间
     */
    private Date replyTime;
    /**
     * id编号
     */
    private Integer id;

    @FieldComment(value = "留言id")
    private Integer leavingId;

    public Integer getLeavingId() {
        return leavingId;
    }

    public void setLeavingId(Integer leavingId) {
        this.leavingId = leavingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
