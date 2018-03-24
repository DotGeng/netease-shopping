package com.netease.dao;

import com.netease.model.Purchase;

/**
 * Created by YukunGeng on 2018/3/24.
 */
public interface PurchaseDao {
    // 向购物车中添加商品
    public void addGoods(Purchase purchase);
}
