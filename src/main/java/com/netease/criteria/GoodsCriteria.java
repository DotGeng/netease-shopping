package com.netease.criteria;

import com.netease.model.GoodsExample;

/**
 * Created by YukunGeng on 2018/3/17.
 */
public class GoodsCriteria {
    public static GoodsExample.Criteria getCriteria(GoodsExample example) {
        return example.createCriteria();
    }
}
