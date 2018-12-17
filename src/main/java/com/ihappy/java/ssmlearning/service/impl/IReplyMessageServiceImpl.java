package com.ihappy.java.ssmlearning.service.impl;

import com.ihappy.java.ssmlearning.dao.IReplyMessageDao;
import com.ihappy.java.ssmlearning.model.ReplyMessage;
import com.ihappy.java.ssmlearning.service.IReplyMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("replyMessageService")
public class IReplyMessageServiceImpl implements IReplyMessageService {
    @Resource
    private IReplyMessageDao replyMessageDao;

    public Integer addOneReplyMessage(ReplyMessage replyMessage) {
        return replyMessageDao.insertOneReplyMessage(replyMessage);
    }

    public List<ReplyMessage> findReplyMessage(Integer leavingId) {
        return replyMessageDao.selectReplyMessage(leavingId);
    }
}
