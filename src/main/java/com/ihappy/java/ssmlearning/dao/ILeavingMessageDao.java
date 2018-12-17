package com.ihappy.java.ssmlearning.dao;

import com.ihappy.java.ssmlearning.bo.QueryLeavingMessageBO;
import com.ihappy.java.ssmlearning.model.LeavingMessage;

import java.util.HashMap;
import java.util.List;

public interface ILeavingMessageDao {
    /**
     * 搜索留言信息列表
     * @param
     * @return
     */
    List<LeavingMessage> selectLeavingMessage(HashMap<String,Object> map);

    /**
     * 新增留言
     * @return
     */
    long insertLeavingMessage(LeavingMessage leavingMessage);

    /**
     * 删除一条留言
     * @param id
     * @return
     */
    long deleteLeavingMessage(long id);

    /**
     * 编辑留言
     * @param leavingMessage
     * @return
     */
    long updateLeavingMessage(LeavingMessage leavingMessage);

    /**
     * 通过id查询一条留言
     * @param id
     * @return
     */
    LeavingMessage queryOneLeavingMessage(Integer id);

    /**
     * 查询留言列表留言数量
     * @param
     * @return
     */

    Integer selectLeavingMessageCount();

    List<LeavingMessage> selectLeavingMessageList();

    Integer bacthRemoveLeavingMessage(List<Integer> idList);
}
