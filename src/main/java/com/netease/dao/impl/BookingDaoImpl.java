package com.netease.dao.impl;

import com.netease.criteria.BookingCriteria;
import com.netease.dao.BookingDao;
import com.netease.mapper.BookingMapper;
import com.netease.model.Booking;
import com.netease.model.BookingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * Created by YukunGeng on 2018/3/23.
 */
@Component
public class BookingDaoImpl implements BookingDao {
    @Autowired
    private BookingMapper boookingMapper;
    @Override
    public Booking getBookingByGoodsId(Integer goodsId) {
        BookingExample example = new BookingExample();
        BookingCriteria.getCriteria(example).andGoodsIdEqualTo(goodsId);
        List<Booking> bookings = boookingMapper.selectByExample(example);
        if(bookings != null && bookings.size() > 0 ) {
            return bookings.get(0);
        }
        return null;
    }
}
