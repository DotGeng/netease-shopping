package com.netease.dao;

import com.netease.model.User;

/**
 * Created by YukunGeng on 2018/3/13.
 */
public interface UserDao {
    public User getUserByUserName(String userName);
}
