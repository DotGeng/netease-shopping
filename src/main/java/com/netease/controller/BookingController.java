package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.model.Booking;
import com.netease.recventry.UserInfo;
import com.netease.response.BookingResponse;
import com.netease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by YukunGeng on 2018/3/27.
 */
@RestController
public class BookingController extends BaseController {
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/booing/user", method = RequestMethod.POST)
    public ResponseStatus getBookingByUserName(UserInfo userInfo) {
        List<BookingResponse> bookingResponses = bookingService.getBookingResponseByUserName(userInfo.getUserName());
        return success("ok", "", bookingResponses);
    }
}
