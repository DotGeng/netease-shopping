package com.netease.dao;

import com.netease.model.Booking;

/**
 * Created by YukunGeng on 2018/3/23.
 */
public interface BookingDao {
    public Booking getBookingByGoodsId(Integer goodsId);
}
