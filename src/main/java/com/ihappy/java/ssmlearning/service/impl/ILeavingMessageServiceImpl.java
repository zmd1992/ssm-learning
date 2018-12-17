package com.ihappy.java.ssmlearning.service.impl;

import com.ihappy.java.ssmlearning.bo.QueryLeavingMessageBO;
import com.ihappy.java.ssmlearning.common.domain.Page;
import com.ihappy.java.ssmlearning.dao.ILeavingMessageDao;
import com.ihappy.java.ssmlearning.model.LeavingMessage;
import com.ihappy.java.ssmlearning.service.ILeavingMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("leavingMessageService")
public class ILeavingMessageServiceImpl implements ILeavingMessageService {
    @Resource
    private ILeavingMessageDao leavingMessageDao;
    public Page<LeavingMessage> getLeavingMessage(Integer  currentPage) {
        HashMap<String,Object> map=new HashMap<>();
        Page<LeavingMessage> page=new Page<LeavingMessage>();
        //封装当前页
        page.setCurrentPage(currentPage);
        //每页显示的数据
        int pageSize=5;
        page.setPageSize(pageSize);
        //封装总记录数
        int totalCount=leavingMessageDao.selectLeavingMessageCount();
        page.setTotal(totalCount);
        //封装总页数
        double tc=totalCount;
        Double num=Math.ceil(tc/pageSize);//向上取整
        page.setTotal(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size",page.getPageSize());
        //封装每页显示的数据
        List<LeavingMessage> leavingMessagesList=leavingMessageDao.selectLeavingMessage(map);
        page.setResult(leavingMessagesList);
        return page;
    }

    @Override
    public List<LeavingMessage> queryLeavingMessageList() {
        return leavingMessageDao.selectLeavingMessageList();
    }

    public long addLeavingMessage(LeavingMessage leavingMessage) {
        return leavingMessageDao.insertLeavingMessage(leavingMessage);
    }

    public long removeLeavingMessage(long id) {
        return leavingMessageDao.deleteLeavingMessage(id);
    }

    public long updateLeavingMessage(LeavingMessage leavingMessage) {
        return leavingMessageDao.updateLeavingMessage(leavingMessage);
    }

    public LeavingMessage queryOneLeavingMessage(Integer id) {
        return leavingMessageDao.queryOneLeavingMessage(id);
    }

    @Override
    public Integer queryLeavingMessageCount() {
        return leavingMessageDao.selectLeavingMessageCount();
    }

    @Override
    public Integer batchDeleteLeavingMessage(List<Integer> idList) {
        return leavingMessageDao.bacthRemoveLeavingMessage(idList);
    }


}
