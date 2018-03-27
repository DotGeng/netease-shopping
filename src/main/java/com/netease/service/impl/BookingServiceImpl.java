package com.netease.service.impl;

import com.netease.dao.BookingDao;
import com.netease.dao.GoodsDao;
import com.netease.mapper.BookingMapperCustom;
import com.netease.model.Booking;
import com.netease.model.Goods;
import com.netease.response.BookingResponse;
import com.netease.response.GoodsResponse;
import com.netease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by YukunGeng on 2018/3/27.
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<BookingResponse> getBookingResponseByUserName(String userName) {
        List<Booking> bookings = bookingDao.getBookingByUserName(userName);
        if (bookings == null || bookings.size() == 0) {
            return null;
        }
        Map<Integer, Booking> bookingId2BookingResponse = new HashMap<>();
        List<Integer> ids = new ArrayList<>();
        for (Booking booking : bookings) {
            bookingId2BookingResponse.put(booking.getGoodsId(), booking);
            ids.add(booking.getGoodsId());
        }
        List<Goods> goodsList = goodsDao.getGoodsByIds(ids);
        for (Goods goods : goodsList) {
            BookingResponse br = new BookingResponse();
            br.setPictureUrl(goods.getPictureUrl());
            br.setTitle(goods.getTitle());
            copy(bookingId2BookingResponse.get(goods.getGoodsId()), br);
            bookingId2BookingResponse.put(goods.getGoodsId(), br);
        }
        Iterator boookingRespItera = bookingId2BookingResponse.values().iterator();
        List<BookingResponse> goodsResponsesRes = new ArrayList<>();
        while(boookingRespItera.hasNext()) {
            goodsResponsesRes.add((BookingResponse)boookingRespItera.next());
        }
        return goodsResponsesRes;
    }

    private void copy(Booking booking, BookingResponse br) {
        br.setBookingId(booking.getBookingId());
        br.setGoodsId(booking.getGoodsId());
        br.setBuyedPrice(booking.getBuyedPrice());
        br.setGoodsNum(booking.getGoodsNum());
        br.setPurchaseTime(booking.getPurchaseTime());
        br.setUsername(booking.getUsername());
    }
}
