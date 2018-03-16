package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.model.Goods;
import com.netease.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YukunGeng on 2018/3/17.
 */
@RestController
public class VisitorController extends BaseController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping(value = "/visitor/all/goods",method = RequestMethod.GET)
    public ResponseStatus getIndesData4Visitor() {
        List<Goods> goods = goodsService.getAllGoods();
        return success("","ok","",goods);
    }
}
