package com.netease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YukunGeng on 2018/3/11.
 */
@Controller
public class GreetingController extends BaseController{
    // 获取登录页面
    @RequestMapping("/get/sessions/new")
    public String hello() {
        return "/login";
    }

    // 获取显商品浏览页面
    @RequestMapping("get/index")
    public String index() {
        return "/index";
    }
}
