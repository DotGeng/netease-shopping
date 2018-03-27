package com.netease.service;

import com.netease.model.Goods;
import com.netease.recventry.GoodsInfo;
import com.netease.response.GoodsResponse;

import java.util.List;
import java.util.Set;

/**
 * Created by YukunGeng on 2018/3/17.
 */
public interface GoodsService {
    public List<Goods> getAllGoods();
    public List<Goods> getGoodsNotSeal();
    public boolean deleteGoodsById(Integer goodsId);
    public Goods getGoodsById(Integer goodsId);
    public void buyGoodsById(Integer goodsId, Integer goodsCount,String userName);
    public List<Goods> getGoodsResponseBuyed(String userName);
    public Integer insertGoods(GoodsInfo goodsInfo);
}
