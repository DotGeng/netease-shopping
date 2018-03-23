package com.netease.model;

public class Booking {
    private Long bookingId;

    private Integer goodsId;

    private Integer goodsNum;

    private Double buyedPrice;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getBuyedPrice() {
        return buyedPrice;
    }

    public void setBuyedPrice(Double buyedPrice) {
        this.buyedPrice = buyedPrice;
    }
}