package com.ihappy.java.ssmlearning.dao;

import com.ihappy.java.ssmlearning.model.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 插入一个账户
     * @param account
     * @return
     */
    long insertOneAccountByCondition(Account account);

    /**
     *搜索账户
     * @param
     * @return
     */
    List<Account> selectAccountByUserName(String userName);

    /**
     *通过用户名获取账户
     * @param
     * @return
     */
    Account  selectAccountByUser(String userName);
    /**
     * 根据用户id查询用户信息
     */
    Account selectAccountInfoById(Integer id);
}
