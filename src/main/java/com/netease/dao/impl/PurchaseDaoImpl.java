package com.netease.dao.impl;

import com.netease.dao.PurchaseDao;
import com.netease.mapper.PurchaseMapper;
import com.netease.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YukunGeng on 2018/3/24.
 */
@Component
public class PurchaseDaoImpl implements PurchaseDao {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Override
    public void addGoods(Purchase purchase) {
        purchaseMapper.insertSelective(purchase);
    }
}
