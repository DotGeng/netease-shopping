package com.netease.criteria;

import com.netease.model.SellerExample;

/**
 * Created by YukunGeng on 2018/3/18.
 */
public class SellerCriteria {
    public static SellerExample.Criteria getCrteriaByExemple(SellerExample example) {
        return example.createCriteria();
    }
}
