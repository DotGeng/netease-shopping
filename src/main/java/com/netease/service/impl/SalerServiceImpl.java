package com.netease.service.impl;

import com.netease.dao.SalerDao;
import com.netease.model.Seller;
import com.netease.service.SalerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YukunGeng on 2018/3/18.
 */
@Service("salerService")
public class SalerServiceImpl implements SalerService {
    @Autowired
    private SalerDao salerDao;
    @Override
    public Seller getSellerBySalerName(String salerName) {
        return salerDao.getSellerBuSalerName(salerName);
    }
}
