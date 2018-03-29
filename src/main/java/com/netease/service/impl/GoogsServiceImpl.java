package com.netease.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.netease.dao.BookingDao;
import com.netease.dao.GoodsDao;
import com.netease.dao.PurchaseDao;
import com.netease.dao.SalerDao;
import com.netease.mapper.BookingMapper;
import com.netease.mapper.PurchaseMapper;
import com.netease.model.Booking;
import com.netease.model.Goods;
import com.netease.model.Purchase;
import com.netease.model.Seller;
import com.netease.recventry.GoodsInfo;
import com.netease.response.GoodsResponse;
import com.netease.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by YukunGeng on 2018/3/17.
 */
@Service
public class GoogsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private SalerDao salerDao;


    @Override
    public List<Goods> getAllGoods() {
        List<Integer> goodsIds = new ArrayList<>();
        List<Goods> goodsList = goodsDao.getAllGoogs();
        Map<Integer, Booking> goodsId2Booking = new HashMap<>();
        for (Goods g : goodsList) {
            goodsIds.add(g.getGoodsId());
        }
        List<Booking> bookingList = bookingDao.getBookingsByGoodsIds(goodsIds);
        for (Booking booking : bookingList) {
            goodsId2Booking.put(booking.getGoodsId(), booking);
        }
        if (bookingList == null) {
            return goodsList;
        }
        for (Goods g : goodsList) {
            if (goodsId2Booking.get(g.getGoodsId()) != null) {
                g.setSoldCount(goodsId2Booking.get(g.getGoodsId()).getGoodsNum());
            }
        }
        return goodsList;
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
        if (goods.getHasSeal().equals("0")) {
            return goods;
        }
        Integer goodsId = goods.getGoodsId();
        Booking booking = bookingDao.getBookingByGoodsId(goods.getGoodsId());
        if (booking == null) {
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


    @Override
    @Transactional
    public void buyGoodsById(Integer goodsId, Integer goodsCount, String userName) {
        Goods goods = goodsDao.getGoodsById(goodsId);
        // 对库存不再限制
       /* if (goods.getStorage() < (goodsCount + goods.getSoldCount())) {
            return;
        }*/
        Purchase purchase = getPurchaseByGoodsId(goodsId);
        if (purchase == null) {
            purchase = new Purchase();
            purchase.setGoodsId(goodsId);
            purchase.setGoodsNum(goodsCount);
            purchase.setPurchaseprice(goods.getGoodsPrice());
            purchase.setUsername(userName);
            purchaseDao.addGoods(purchase);
        } else {
            purchase.setGoodsNum(purchase.getGoodsNum() + goodsCount);
            purchaseDao.updatePurchaseById(purchase);
        }
        goodsDao.updateGoodsById(goods);
    }

    private Purchase getPurchaseByGoodsId(Integer goodsId) {
        List<Purchase> purchases = purchaseDao.getPurchaseByGoodsId(goodsId);
        if (purchases != null && purchases.size() > 0) {
            return purchases.get(0);
        }
        return null;
    }

    @Override
    public List<Goods> getGoodsResponseBuyed(String usrName) {
        Map<Integer, Goods> goodsMap = new HashMap<>();
        List<Purchase> purchases = purchaseDao.getPurchases(usrName);
        if (purchases == null || purchases.size() == 0) {
            return null;
        }
        List<Integer> goodsIds = new ArrayList<>();
        for (Purchase purchase : purchases) {
            goodsIds.add(purchase.getGoodsId());
        }
        List<Goods> goods = goodsDao.getGoodsByIds(goodsIds);
        for (Goods gds : goods) {
            goodsMap.put(gds.getGoodsId(), gds);
        }
        for (Purchase purchase : purchases) {
            Goods tmpGoods = goodsMap.get(purchase.getGoodsId());
            tmpGoods.setSoldCount(purchase.getGoodsNum());
        }
        List<Goods> goodsList = new ArrayList<>();
        Iterator<Goods> iterator = goodsMap.values().iterator();
        while (iterator.hasNext()) {
            goodsList.add(iterator.next());
        }

        return goodsList;
    }

    private GoodsResponse copy(GoodsResponse gr, Goods gds) {
        gr.setGoodsAbstract(gds.getGoodsAbstract());
        gr.setContent(gds.getContent());
        gr.setHasSeal(gds.getHasSeal());
        gr.setPictureUrl(gds.getPictureUrl());
        gr.setSoldCount(gds.getSoldCount());
        gr.setTitle(gds.getTitle());
        gr.setGoodsName(gds.getGoodsName());
        gr.setStorage(gds.getStorage());
        gr.setSellerId(gds.getSellerId());
        gr.setGoodsPrice(gds.getGoodsPrice());
        return gr;
    }

    @Override
    @Transactional
    public Integer insertGoods(GoodsInfo goodsInfo) {
        Seller seller = salerDao.getSellerBuSalerName(goodsInfo.getSalerName());
        Goods goods = new Goods();
        goods.setContent(goodsInfo.getContent());
        goods.setSellerId(seller.getSellerId());
        goods.setGoodsAbstract(goodsInfo.getGoodsAbstract());
        goods.setGoodsName(goodsInfo.getGoodsName());
        goods.setGoodsPrice(goodsInfo.getGoodsPrice());
        goods.setPictureUrl(goodsInfo.getPictureUrl());
        goods.setTitle(goodsInfo.getTitle());
        goods.setGoodsName(goodsInfo.getTitle());
        goodsDao.insetGoods(goods);
        return goods.getGoodsId();
    }

    @Override
    @Transactional
    public void changeGoodsInfo(GoodsInfo goodsInfo) {
        Seller seller = salerDao.getSellerBuSalerName(goodsInfo.getSalerName());
        Goods goods = new Goods();
        goods.setSellerId(seller.getSellerId());
        copy(goodsInfo, goods);
        goods.setSellerId(seller.getSellerId());
        goodsDao.updateGoods(goods);

    }

    private void copy(GoodsInfo goodsInfo, Goods goods) {
        goods.setGoodsId(goodsInfo.getGoodsId());
        goods.setContent(goodsInfo.getContent());
        goods.setGoodsAbstract(goodsInfo.getGoodsAbstract());
        goods.setGoodsName(goodsInfo.getGoodsName());
        goods.setGoodsPrice(goodsInfo.getGoodsPrice());
        goods.setPictureUrl(goodsInfo.getPictureUrl());
        goods.setTitle(goodsInfo.getTitle());
        goods.setGoodsName(goodsInfo.getTitle());
    }
}
