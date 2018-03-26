package com.netease.criteria;

import com.netease.model.PurchaseExample;

/**
 * Created by YukunGeng on 2018/3/24.
 */
public class PurchaseCriteria {
    public static PurchaseExample.Criteria getCriteria(PurchaseExample example) {
        return example.createCriteria();
    }
}
