package com.netease.model;

public class Purchase {
    private Long purchasedId;

    private Integer goodsId;

    private Integer goodsNum;

    private String username;

    private Double purchaseprice;

    public Long getPurchasedId() {
        return purchasedId;
    }

    public void setPurchasedId(Long purchasedId) {
        this.purchasedId = purchasedId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }
}