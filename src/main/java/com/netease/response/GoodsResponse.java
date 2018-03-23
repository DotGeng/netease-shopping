package com.netease.response;

import com.netease.model.Goods;

/**
 * Created by YukunGeng on 2018/3/23.
 */
public class GoodsResponse extends Goods {
    private Double buyedPrice;

    public Double getBuyedPrice() {
        return buyedPrice;
    }

    public void setBuyedPrice(Double buyedPrice) {
        this.buyedPrice = buyedPrice;
    }
}
