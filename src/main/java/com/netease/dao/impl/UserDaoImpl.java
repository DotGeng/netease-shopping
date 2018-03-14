package com.netease.dao.impl;

import com.netease.criteria.UserCriteria;
import com.netease.dao.UserDao;
import com.netease.mapper.UserMapper;
import com.netease.model.User;
import com.netease.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/13.
 */
@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByUserName(String userName) {
        UserExample example = new UserExample();
        UserCriteria.getUserCriteByUserName(example).andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(example);
        if(users == null || users.size() == 0) {
            return null;
        }
        return users.get(0);
    }
}
