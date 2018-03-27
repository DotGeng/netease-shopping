package com.netease.service.impl;


import com.netease.criteria.GoodsCriteria;
import com.netease.dao.BookingDao;
import com.netease.dao.GoodsDao;
import com.netease.dao.PurchaseDao;
import com.netease.model.Booking;
import com.netease.model.Goods;
import com.netease.model.GoodsExample;
import com.netease.model.Purchase;
import com.netease.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YukunGeng on 2018/3/25.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    @Transactional
    public void cleanPurchaseByUserName(String userName) {
        List<Purchase> purchases = purchaseDao.getPurchases(userName);
        List<Booking> bookings = new ArrayList<>();
        List<Integer> goodsIds = new ArrayList<>();
        for (Purchase p : purchases) {
            Booking booking = new Booking();
            booking.setGoodsId(p.getGoodsId());
            booking.setUsername(p.getUsername());
            booking.setGoodsNum(p.getGoodsNum());
            booking.setPurchaseTime(new Date());
            booking.setBuyedPrice(p.getPurchaseprice());
            bookings.add(booking);
            goodsIds.add(p.getGoodsId());
        }
        Goods goods = new Goods();
        goods.setHasSeal(1);
        updateGoodsHasSaled(goodsIds, goods);
        purchaseDao.deletePurchaseByUserName(userName);
        bookingDao.insertBatchBooking(bookings);
    }

    private void updateGoodsHasSaled(List<Integer> goodsIds, Goods goods) {
        GoodsExample example = new GoodsExample();
        GoodsCriteria.getCriteria(example).andGoodsIdIn(goodsIds);
        goodsDao.updateGoods2HasSaldByIds(goodsIds, goods);
    }
}
