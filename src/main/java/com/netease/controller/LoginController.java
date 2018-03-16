package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.model.User;
import com.netease.recventry.UserInfo;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by YukunGeng on 2018/3/9.
 */

@RestController
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;
    // 登录
    @RequestMapping(value = "/post/sessions/create",method = RequestMethod.POST)
    public ResponseStatus login(@ModelAttribute UserInfo userInfo, HttpSession session) {
        return success(session.getId(),"ok",userInfo.getUserName(),"");
    }
    // 注销
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResponseStatus test(@ModelAttribute UserInfo userInfo, HttpSession session) {
        return success(session.getId(),"ok","1","");
    }


}
