package com.ihappy.java.ssmlearning.service.impl;

import com.ihappy.java.ssmlearning.dao.IAccountDao;
import com.ihappy.java.ssmlearning.model.Account;
import com.ihappy.java.ssmlearning.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class IAccountServiceImpl implements IAccountService {
    @Resource
    private IAccountDao accountDao;

    public long registerOneAccountByCondition(Account account) {
        return accountDao.insertOneAccountByCondition(account);
    }


    public List<Account> getUserInfoByUserName(String userName) {
        return accountDao.selectAccountByUserName(userName);
    }

    public Account getUserInfoByUser(String userName) {
        return accountDao.selectAccountByUser(userName);
    }

    public Account getUserInfoById(Integer id) {
        return null;
    }

}
