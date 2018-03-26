package com.netease.dao;

import com.netease.model.Goods;
import com.netease.model.Purchase;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/24.
 */
public interface PurchaseDao {
    // 向购物车中添加商品
    public void addGoods(Purchase purchase);
    public List<Purchase> getPurchaseByGoodsId(Integer goodId);
    public void updatePurchaseById(Purchase purchase);
    public List<Purchase> getPurchases(String userName);
    public int deletePurchaseByUserName(String userName);
}
