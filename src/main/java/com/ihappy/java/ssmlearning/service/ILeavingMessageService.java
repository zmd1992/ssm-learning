package com.ihappy.java.ssmlearning.service;

import com.ihappy.java.ssmlearning.bo.QueryLeavingMessageBO;
import com.ihappy.java.ssmlearning.common.domain.Page;
import com.ihappy.java.ssmlearning.model.LeavingMessage;

import java.util.List;

public interface ILeavingMessageService {
    /**
     * 分页查询留言列表
     *
     * @param
     * @return
     */
    Page<LeavingMessage> getLeavingMessage(Integer currentPage);
    /**
     * 查询留言列表
     */
    List<LeavingMessage> queryLeavingMessageList();

    /**
     * 添加留言
     *
     * @param leavingMessage
     * @return
     */
    long addLeavingMessage(LeavingMessage leavingMessage);

    /**
     * 删除一条留言
     *
     * @param id
     * @return
     */
    long removeLeavingMessage(long id);

    /**
     * 修改一条留言
     *
     * @param leavingMessage
     * @return
     */
    long updateLeavingMessage(LeavingMessage leavingMessage);

    /**
     * 查询一条留言
     *
     * @param id
     * @return
     */
    LeavingMessage queryOneLeavingMessage(Integer id);

    /**
     * 查询留言列表数量
     *
     * @param
     * @return
     */

    Integer queryLeavingMessageCount();

    Integer batchDeleteLeavingMessage(List<Integer> idList);
}
