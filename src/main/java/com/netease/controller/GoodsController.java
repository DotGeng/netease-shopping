package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.model.Goods;
import com.netease.recventry.GoodsInfo;
import com.netease.recventry.UserInfo;
import com.netease.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        if(goodsId == null) {
            return error("error","","");
        }
        if(goodsService.deleteGoodsById(goodsId)) {
            return success("ok","");
        }
        return error("error","","");
    }
    @RequestMapping(value = "/goods/detail", method = RequestMethod.POST)
    public ResponseStatus getGoodsByGoodsId(GoodsInfo goodsInfo) {
        if(goodsInfo == null && goodsInfo.getGoodsId() == null) {
            return error("fail","","");
        }
        Goods goods = goodsService.getGoodsById(goodsInfo.getGoodsId());
        return success("ok","",goods);
    }
}