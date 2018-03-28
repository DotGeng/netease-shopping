package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.model.Goods;
import com.netease.recventry.GoodsInfo;
import com.netease.recventry.UserInfo;
import com.netease.response.GoodsResponse;
import com.netease.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by YukunGeng on 2018/3/18.
 */
@RestController
public class GoodsController extends BaseController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goods/not/seal", method = RequestMethod.POST)
    public ResponseStatus getAllGoodsNotSeal(UserInfo userInfo) {
        List<Goods> goods = goodsService.getGoodsNotSeal();
        return success("ok", userInfo.getUserName(), goods);
    }

    @RequestMapping(value = "/saler/all/goods", method = RequestMethod.POST)
    public ResponseStatus getAllGoods(UserInfo userInfo) {
        List<Goods> goods = goodsService.getAllGoods();
        return success("ok", userInfo.getUserName(), goods);
    }

    @RequestMapping(value = "/saler/goods/delete", method = RequestMethod.POST)
    public ResponseStatus deleteGoodsByGoodsId(GoodsInfo goodsInfo) {
        Integer goodsId = goodsInfo.getGoodsId();
        if (goodsId == null) {
            return error("error", "", "");
        }
        if (goodsService.deleteGoodsById(goodsId)) {
            return success("ok", "");
        }
        return error("error", "", "");
    }

    @RequestMapping(value = "/goods/detail", method = RequestMethod.POST)
    public ResponseStatus getGoodsByGoodsId(GoodsInfo goodsInfo) {
        if (goodsInfo == null && goodsInfo.getGoodsId() == null) {
            return error("fail", "", "");
        }
        Goods goods = goodsService.getGoodsById(goodsInfo.getGoodsId());
        return success("ok", "", goods);
    }

    @RequestMapping(value = "/goods/buying", method = RequestMethod.POST)
    public ResponseStatus buyGoods(GoodsInfo goodsInfo) {
        Integer goodsId = goodsInfo.getGoodsId();
        Integer goodsCount = goodsInfo.getCount();
        goodsService.buyGoodsById(goodsId, goodsCount, goodsInfo.getUserName());
        return success("ok", "");
    }

    @RequestMapping(value = "/goods/purchased", method = RequestMethod.POST)
    public ResponseStatus getPurchaseGoods(UserInfo userInfo) {
        List<Goods> goods = goodsService.getGoodsResponseBuyed(userInfo.getUserName());
        return success("ok", "", goods);
    }

    @RequestMapping(value = "/goods/adding", method = RequestMethod.POST)
    public ResponseStatus insertGoods(GoodsInfo goodsInfo) {
        Integer goodsId = goodsService.insertGoods(goodsInfo);
        GoodsResponse gr = new GoodsResponse();
        gr.setGoodsId(goodsId);
        return success("ok", "", gr);
    }

    @RequestMapping(value = "/goods/changing", method = RequestMethod.POST)
    public ResponseStatus changeGoodsInfo(GoodsInfo goodsInfo) {
        goodsService.changeGoodsInfo(goodsInfo);
        return success("ok","","");
    }
}
