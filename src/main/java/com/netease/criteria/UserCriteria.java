package com.netease.criteria;

import com.netease.model.UserExample;

/**
 * Created by YukunGeng on 2018/3/14.
 */

public class UserCriteria {
    public static UserExample.Criteria getUserCriteByUserName(UserExample example) {
        UserExample.Criteria criteria = example.createCriteria();
        return criteria;
    }
}
