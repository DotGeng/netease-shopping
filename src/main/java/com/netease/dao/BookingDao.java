package com.netease.dao;

import com.netease.model.Booking;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/23.
 */
public interface BookingDao {
    public Booking getBookingByGoodsId(Integer goodsId);

    public int insertBatchBooking(List<Booking> bookings);

    public List<Booking> getBookingByUserName(String userName);

    public List<Booking> getBookingsByGoodsIds(List<Integer> goodsIds);
}
