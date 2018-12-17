package com.ihappy.java.ssmlearning.service;

import com.ihappy.java.ssmlearning.model.ReplyMessage;

import java.util.List;

public interface IReplyMessageService {
    /**
     * 通过id回复
     * @param replyMessage
     * @return
     */
    Integer addOneReplyMessage(ReplyMessage replyMessage);

    /**
     * 根据留言id查看留言回复列表
     * @return
     */
    List<ReplyMessage> findReplyMessage(Integer leavingId);
}
