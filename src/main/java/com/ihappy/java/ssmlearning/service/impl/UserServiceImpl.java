package com.ihappy.java.ssmlearning.service.impl;

import javax.annotation.Resource;


import com.ihappy.java.ssmlearning.dao.IUserDao;
import com.ihappy.java.ssmlearning.model.User;
import com.ihappy.java.ssmlearning.service.IUserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    public User getUserById(int userId) {
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);
    }

}  
