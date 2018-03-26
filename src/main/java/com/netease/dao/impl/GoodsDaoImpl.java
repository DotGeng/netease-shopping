package com.netease.dao.impl;

import com.netease.criteria.GoodsCriteria;
import com.netease.dao.GoodsDao;
import com.netease.mapper.GoodsMapper;
import com.netease.model.Goods;
import com.netease.model.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/17.
 */
@Component
public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> getAllGoogs() {
        GoodsExample example = new GoodsExample();
        GoodsCriteria.getCriteria(example);
        List<Goods> goods = goodsMapper.selectByExample(example);
        return goods;
    }

    @Override
    public List<Goods> getGoodsNotSeal() {
        GoodsExample example = new GoodsExample();
        GoodsCriteria.getCriteria(example).andHasSealEqualTo(0);
        List<Goods> goods = goodsMapper.selectByExample(example);
        return goods;
    }

    @Override
    public boolean deleteGoodById(Integer goodsId) {
        int res = goodsMapper.deleteByPrimaryKey(goodsId);
        if(res > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }

    @Override
    public void updateGoodsById(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public List<Goods> getGoodsByIds(List<Integer> goodIds) {
        GoodsExample example = new GoodsExample();
        GoodsCriteria.getCriteria(example).andGoodsIdIn(goodIds);
        List<Goods> goods = goodsMapper.selectByExample(example);
        return goods;
    }
}
