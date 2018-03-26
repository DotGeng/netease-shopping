package com.netease.response;

import com.netease.model.Goods;

import java.util.Date;

/**
 * Created by YukunGeng on 2018/3/23.
 */
public class GoodsResponse extends Goods {
    private Double buyedPrice;
    private Date buyingTime;

    public Date getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(Date buyingTime) {
        this.buyingTime = buyingTime;
    }

    public Double getBuyedPrice() {
        return buyedPrice;
    }

    public void setBuyedPrice(Double buyedPrice) {
        this.buyedPrice = buyedPrice;
    }
}
