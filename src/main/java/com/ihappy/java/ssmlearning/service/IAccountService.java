package com.ihappy.java.ssmlearning.service;

import com.ihappy.java.ssmlearning.dao.IAccountDao;
import com.ihappy.java.ssmlearning.model.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService {
    /**
     * 通过用户名和密码注册账户
     * @param account
     * @return
     */
    long registerOneAccountByCondition(Account account);

    /**
     * 通过用户名获取账户信息
     * @param
     * @return
     */
    List<Account> getUserInfoByUserName(String userName);

    /**
     * 通过用户名获取账户
     * @param userName
     * @return
     */
    Account  getUserInfoByUser(String userName);
    /**
     * 根据用户id查询用户信息
     */
    Account getUserInfoById(Integer id);
}
