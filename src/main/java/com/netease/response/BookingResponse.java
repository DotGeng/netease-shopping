package com.netease.response;

import com.netease.model.Booking;

import java.util.Date;

/**
 * Created by YukunGeng on 2018/3/27.
 */
public class BookingResponse extends Booking {
    private String title;
    private String pictureUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
