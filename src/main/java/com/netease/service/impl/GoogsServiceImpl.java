package com.netease.service.impl;

import com.netease.dao.BookingDao;
import com.netease.dao.GoodsDao;
import com.netease.mapper.BookingMapper;
import com.netease.model.Booking;
import com.netease.model.Goods;
import com.netease.response.GoodsResponse;
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
    @Autowired
    private BookingDao bookingDao;

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoogs();
    }

    @Override
    public List<Goods> getGoodsNotSeal() {
        return goodsDao.getGoodsNotSeal();
    }

    @Override
    public boolean deleteGoodsById(Integer goodsId) {
        return goodsDao.deleteGoodById(goodsId);
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        Goods goods = goodsDao.getGoodsById(goodsId);
        if (goods == null) {
            return null;
        }
        return getGoodesAddedBuyedPrice(goods);
    }

    private Goods getGoodesAddedBuyedPrice(Goods goods) {
        if(goods.getHasSeal().equals("0")) {
            return goods;
        }
        Integer goodsId = goods.getGoodsId();
        Booking booking = bookingDao.getBookingByGoodsId(goods.getGoodsId());
        if(booking == null) {
            return goods;
        }
        GoodsResponse goodsResponse = new GoodsResponse();
        goodsResponse.setGoodsId(goods.getGoodsId());
        goodsResponse.setGoodsName(goods.getGoodsName());
        goodsResponse.setGoodsPrice(goods.getGoodsPrice());
        goodsResponse.setPictureUrl(goods.getPictureUrl());
        goodsResponse.setStorage(goods.getStorage());
        goodsResponse.setTitle(goods.getTitle());
        goodsResponse.setSoldCount(goods.getSoldCount());
        goodsResponse.setSellerId(goods.getSellerId());
        goodsResponse.setHasSeal(goods.getHasSeal());
        goodsResponse.setContent(goods.getContent());
        goodsResponse.setGoodsAbstract(goods.getGoodsAbstract());
        goodsResponse.setBuyedPrice(booking.getBuyedPrice());
        return goodsResponse;
    }
}
