package com.netease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YukunGeng on 2018/3/11.
 */
@Controller
public class GreetingController extends BaseController{

    @RequestMapping("get/index/not/login")
    public String getIndexWithoutLogin() {
        return "/index";
    }

    // 买家获取登录页面
    @RequestMapping("/get/sessions/new")
    public String hello() {
        return "/login";
    }
    // 卖家获取登录页面
    @RequestMapping("/get/sessions/seller/news")
    public String salerLongin() {
        return "/salerlogin";
    }

    @RequestMapping("/get/sessions/saler/index")
    public String salerIndex() {
        return "/salerIndex";
    }

    @RequestMapping("/static/saler/index")
    public String staticSalerIndex() {
        return "/salerIndex";
    }
    // 获取显商品浏览页面
    @RequestMapping("/get/index")
    public String index() {
        return "/index";
    }
    // 买家获取商品详细页
    @RequestMapping("/goods/page/detail")
    public String showGoodsDetailForUser() {
        return "/show";
    }
    // 卖家获获取商品详细信息
    @RequestMapping("/static/show/saler")
    public String showGoodInfoForSaler() {
        return "/salershow";
    }
    @RequestMapping("/static/show/purchase")
    public String showAccountDetail() {
        return "/purchase";
    }
    @RequestMapping("/static/show/account")
    public String showAccount() {
        return "/account";
    }
    //获取发布页面
    @RequestMapping("/static/show/publish")
    public  String showPublish() {
        return "/public";
    }
    // 获取编辑页面
    @RequestMapping("/static/show/editor")
    public String editor(){
        return "/edit";
    }

}
