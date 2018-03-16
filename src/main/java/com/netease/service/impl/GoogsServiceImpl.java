package com.netease.service.impl;

import com.netease.dao.GoodsDao;
import com.netease.model.Goods;
import com.netease.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/17.
 */
@Service
public class GoogsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoogs();
    }
}
