package com.netease.dao.impl;

import com.netease.criteria.SellerCriteria;
import com.netease.dao.SalerDao;
import com.netease.mapper.SellerMapper;
import com.netease.model.Seller;
import com.netease.model.SellerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/18.
 */
@Component
public class SalerDaoImpl implements SalerDao {
    @Autowired
    private SellerMapper sellerMapper;
    @Override
    public Seller getSellerBuSalerName(String salerName) {
        SellerExample example = new SellerExample();
        SellerCriteria.getCrteriaByExemple(example).andSellerNameEqualTo(salerName);
        List<Seller> sellers = sellerMapper.selectByExample(example);
        if(sellers != null) {
            return sellers.get(0);
        }
        return null;
    }
}
