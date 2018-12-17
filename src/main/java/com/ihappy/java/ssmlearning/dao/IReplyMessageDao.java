package com.ihappy.java.ssmlearning.dao;

import com.ihappy.java.ssmlearning.model.ReplyMessage;

import java.util.List;

public interface IReplyMessageDao {
    /**
     * 插入一条回复
     * @param replyMessage
     * @return
     */
     Integer insertOneReplyMessage(ReplyMessage replyMessage);

    /**
     * 根据留言id查询留言回复列表
     * @return
     */
     List<ReplyMessage> selectReplyMessage(Integer leavingId);
}
