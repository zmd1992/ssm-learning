package com.ihappy.java.ssmlearning.dao;

import com.ihappy.java.ssmlearning.model.User;


public interface IUserDao {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int insert(User record);


    /**
     * @param record
     * @return
     */
    int insertSelective(User record);


    /**
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);


    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);


    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}