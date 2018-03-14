package com.netease.service.impl;

import com.netease.criteria.UserCriteria;
import com.netease.dao.UserDao;
import com.netease.mapper.UserMapper;
import com.netease.model.User;
import com.netease.model.UserExample;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by YukunGeng on 2018/3/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserInfoByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
