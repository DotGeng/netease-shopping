package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.recventry.UserInfo;
import com.netease.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YukunGeng on 2018/3/25.
 */
@RestController
public class PurchaseController extends BaseController{
    @Autowired
    private PurchaseService purchaseService;
    @RequestMapping(value = "/goods/purchased/clean", method = RequestMethod.POST)
    public ResponseStatus cleanPurchaseCart(UserInfo userInfo) {
        purchaseService.cleanPurchaseByUserName(userInfo.getUserName());
        return success("ok","","");
    }
}
