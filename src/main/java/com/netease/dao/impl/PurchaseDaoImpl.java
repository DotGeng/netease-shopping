package com.netease.dao.impl;

import com.netease.criteria.GoodsCriteria;
import com.netease.criteria.PurchaseCriteria;
import com.netease.dao.PurchaseDao;
import com.netease.mapper.PurchaseMapper;
import com.netease.model.Goods;
import com.netease.model.GoodsExample;
import com.netease.model.Purchase;
import com.netease.model.PurchaseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<Purchase> getPurchaseByGoodsId(Integer goodId) {
        PurchaseExample example = new PurchaseExample();
        PurchaseCriteria.getCriteria(example).andGoodsIdEqualTo(goodId);
        return purchaseMapper.selectByExample(example);
    }

    @Override
    public void updatePurchaseById( Purchase purchase) {
        purchaseMapper.updateByPrimaryKey(purchase);
    }

    @Override
    public List<Purchase> getPurchases(String userName) {
        PurchaseExample example = new PurchaseExample();
        PurchaseCriteria.getCriteria(example).andUsernameEqualTo(userName);
        List<Purchase> purchases = purchaseMapper.selectByExample(example);
        return purchases;
    }

    @Override
    public int deletePurchaseByUserName(String userName) {
        PurchaseExample example = new PurchaseExample();
        PurchaseCriteria.getCriteria(example).andUsernameEqualTo(userName);
        return purchaseMapper.deleteByExample(example);
    }
}
