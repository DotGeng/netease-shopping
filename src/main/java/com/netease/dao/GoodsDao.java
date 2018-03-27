package com.netease.dao;

import com.netease.model.Goods;
import com.netease.recventry.GoodsInfo;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/17.
 */
public interface GoodsDao {
    public List<Goods> getAllGoogs();
    public List<Goods> getGoodsNotSeal();
    public boolean deleteGoodById(Integer goodsId);
    public Goods getGoodsById(Integer goodsId);
    public void updateGoodsById(Goods goods);
    public List<Goods> getGoodsByIds(List<Integer> goodIds);
    public void updateGoods2HasSaldByIds(List<Integer> goodsIds, Goods goods);
    public void insetGoods(Goods goods);
}
