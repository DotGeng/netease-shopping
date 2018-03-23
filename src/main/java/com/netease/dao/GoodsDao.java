package com.netease.dao;

import com.netease.model.Goods;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/17.
 */
public interface GoodsDao {
    public List<Goods> getAllGoogs();
    public List<Goods> getGoodsNotSeal();
    public boolean deleteGoodById(Integer goodsId);
    public Goods getGoodsById(Integer goodsId);
}