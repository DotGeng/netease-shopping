package com.netease.service;

import com.netease.model.Goods;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/17.
 */
public interface GoodsService {
    public List<Goods> getAllGoods();
    public List<Goods> getGoodsNotSeal();
    public boolean deleteGoodsById(Integer goodsId);
    public Goods getGoodsById(Integer goodsId);
    public void buyGoodsById(Integer goodsId, Integer goodsCount);
}
