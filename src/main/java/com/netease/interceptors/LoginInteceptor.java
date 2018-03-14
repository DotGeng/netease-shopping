package com.netease.interceptors;


import com.netease.controller.BaseController;
import com.netease.model.User;
import com.netease.recventry.UserInfo;
import com.netease.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by YukunGeng on 2018/3/13.
 */

public class LoginInteceptor implements HandlerInterceptor {


    private UserService userService;

    private HttpServletRequest getRequest(HttpServletRequest req){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(req.getServletContext());
        return multipartResolver.resolveMultipart(req);
    }

    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //request = this.getRequest(request);
        if (userService == null) {//解决service为null无法注入问题
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (UserService) factory.getBean("userService");
        }
        HttpSession session = request.getSession();
        Object userName = request.getParameter("userName");
        Object password = request.getParameter("password");
        if(userName == null && password == null) {
            return false;
        }
        if(password == null ) {
            // 代表该用户不是第一次访问系统
            if (session.getAttribute(userName.toString()) != null) {
                session.setMaxInactiveInterval(15 * 60);
                return true;
            }
        }
        UserInfo userInfo = (UserInfo)session.getAttribute(userName.toString());
        if(userInfo == null) {
            // 访问数据库，验证用户名和密码的正确性
            User user = userService.getUserInfoByUserName(userName.toString());
            String passwordInDb = user.getPassword();
            if(user == null || !passwordInDb.equals(password.toString())) {
                response.getWriter().append("{\"code\": 1,\"content\": \"error\"}");

                return false;
            }
            // 设定session
            session.setAttribute(userName.toString(), userInfo);
            session.setMaxInactiveInterval(15 * 60);

            return true;
        }
        if(!password.toString().equals(userInfo.getPassword())) {
            return false;
        }
        session.setMaxInactiveInterval(15 * 60);
        return true;
    }


}
