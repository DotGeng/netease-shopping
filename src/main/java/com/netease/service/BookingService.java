package com.netease.service;

import com.netease.model.Booking;
import com.netease.response.BookingResponse;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/27.
 */
public interface BookingService {
    public List<BookingResponse> getBookingResponseByUserName(String userName);
}
