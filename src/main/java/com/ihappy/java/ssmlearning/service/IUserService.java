package com.ihappy.java.ssmlearning.service;

import com.ihappy.java.ssmlearning.model.User;


public interface IUserService {
    /**
     * @param userId
     * @return
     */
    User getUserById(int userId);
}  