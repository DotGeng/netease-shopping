package com.netease.controller;

import com.netease.BaseController.SalerResponseStatus;
import com.netease.criteria.SellerCriteria;
import com.netease.model.Seller;
import com.netease.model.SellerExample;
import com.netease.recventry.SalerInfo;
import com.netease.recventry.UserInfo;
import com.netease.service.SalerService;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YukunGeng on 2018/3/18.
 */
@RestController
public class SellController extends BaseController {
    @Autowired
    private SalerService salerService;
    @RequestMapping("/sessions/saler/index")
    public SalerResponseStatus getSalerBySalerName(SalerInfo salerInfo) {
        String salerName = salerInfo.getSalerName();
        Seller seller = salerService.getSellerBySalerName(salerName);
        /*if(seller != null && seller.getPassword().equals(salerInfo.getPassword())) {
            return success4Saler("ok",salerName,"");
        }else{
            return null;
        }*/
        return success4Saler("ok",salerName,"");
    }

}
