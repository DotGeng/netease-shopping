package com.netease.model;

public class Goods {
    private Integer goodsId;

    private String goodsName;

    private String goodsPrice;

    private String pictureUrl;

    private Integer storage;

    private String title;

    private Integer soldCount;

    private Long sellerId;

    private Integer hasSeal;

    private String content;

    private String goodsAbstract;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getHasSeal() {
        return hasSeal;
    }

    public void setHasSeal(Integer hasSeal) {
        this.hasSeal = hasSeal;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getGoodsAbstract() {
        return goodsAbstract;
    }

    public void setGoodsAbstract(String goodsAbstract) {
        this.goodsAbstract = goodsAbstract == null ? null : goodsAbstract.trim();
    }
}