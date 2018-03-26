package com.netease.dao.impl;

import com.netease.criteria.BookingCriteria;
import com.netease.dao.BookingDao;
import com.netease.mapper.BookingMapper;
import com.netease.mapper.BookingMapperCustom;
import com.netease.model.Booking;
import com.netease.model.BookingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/23.
 */
@Component
public class BookingDaoImpl implements BookingDao {
    @Autowired
    private BookingMapperCustom boookingMapperCustom;
    @Override
    public Booking getBookingByGoodsId(Integer goodsId) {
        BookingExample example = new BookingExample();
        BookingCriteria.getCriteria(example).andGoodsIdEqualTo(goodsId);
        List<Booking> bookings = boookingMapperCustom.selectByExample(example);
        if(bookings != null && bookings.size() > 0 ) {
            return bookings.get(0);
        }
        return null;
    }

    @Override
    public int insertBatchBooking(List<Booking> bookings) {
        int res = boookingMapperCustom.insertCodeBatch(bookings);
        return res;
    }
}
