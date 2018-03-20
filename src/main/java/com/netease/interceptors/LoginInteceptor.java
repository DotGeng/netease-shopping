package com.netease.interceptors;


import com.netease.controller.BaseController;
import com.netease.model.Seller;
import com.netease.model.User;
import com.netease.recventry.SalerInfo;
import com.netease.recventry.UserInfo;
import com.netease.service.SalerService;
import com.netease.service.UserService;
import com.netease.util.CookieUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/**
 * Created by YukunGeng on 2018/3/13.
 */

public class LoginInteceptor implements HandlerInterceptor {


    private UserService userService;
    private SalerService salerService;

    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String userName = request.getParameter("userName");
        String salerName = request.getParameter("salerName");
        String URL = request.getRequestURI();
        if (request.getParameter("userName") != null) {
            // 买家登录的过滤器
            return buyerLoginInteceptor(request, response, handler);
        }
        if (request.getParameter("salerName") != null) {
            // 卖家过滤器
            return salerLogIntecptor(request, response, handler);
        } else {
            return false;
        }

    }

    // 卖家登陆过滤器
    public boolean salerLogIntecptor(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        System.out.println(url);
        if (salerService == null) {//解决service为null无法注入问题
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            salerService = (SalerService) factory.getBean("salerService");
        }

        Object salerName = request.getParameter("salerName");
        Object password = request.getParameter("password");
        if (salerName == null && password == null) {
            return false;
        }
        if (password == null) {
            // 代表该用户不是第一次访问系统
            if (session.getAttribute(salerName.toString()) != null) {
                // 首先通过cookie获得userName
                String nameFromCookie = CookieUtils.getCookieValue(request, "NE_SHOPPING_SALER");
                if (nameFromCookie != null) {
                    if (session.getAttribute(nameFromCookie) != null) {
                        session.setMaxInactiveInterval(15 * 60);
                        return true;
                    }
                }
                return false;
            }
        }
        SalerInfo salerInfo = (SalerInfo) session.getAttribute(salerName.toString());
        if (salerInfo == null) {
            // 访问数据库，验证用户名和密码的正确性
            Seller seller = salerService.getSellerBySalerName(salerName.toString());
            String passwordInDb = seller.getPassword();
            if (seller == null || !passwordInDb.equals(password.toString())) {
                response.getWriter().append("{\"code\": 1,\"content\": \"error\"}");

                return false;
            }
            // 设定session
            session.setAttribute(salerName.toString(), new SalerInfo(salerName.toString(), password.toString()));
            session.setMaxInactiveInterval(15 * 60);
            // 设置cookie
            CookieUtils.setCookie(request, response, "NE_SHOPPING_SALER", salerName.toString());
            return true;
        }
        if (!password.toString().equals(salerInfo.getPassword())) {
            return false;
        }
        session.setMaxInactiveInterval(15 * 60);
        return true;
    }

    // 买家登录的过滤器
    public boolean buyerLoginInteceptor(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        System.out.println(url);
        if (userService == null) {//解决service为null无法注入问题
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (UserService) factory.getBean("userService");
        }

        Object userName = request.getParameter("userName");
        Object password = request.getParameter("password");
        if (userName == null && password == null) {
            return false;
        }
        if (password == null) {
            // 代表该用户不是第一次访问系统
            if (session.getAttribute(userName.toString()) != null) {
                // 首先通过cookie获得userName
                String nameFromCookie = CookieUtils.getCookieValue(request, "NE_SHOPPING");
                if (nameFromCookie != null) {
                    if (session.getAttribute(nameFromCookie) != null) {
                        session.setMaxInactiveInterval(15 * 60);
                        return true;
                    }
                }
                return false;
            }
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(userName.toString());
        if (userInfo == null) {
            // 访问数据库，验证用户名和密码的正确性
            User user = userService.getUserInfoByUserName(userName.toString());
            String passwordInDb = user.getPassword();
            if (user == null || !passwordInDb.equals(password.toString())) {
                response.getWriter().append("{\"code\": 1,\"content\": \"error\"}");

                return false;
            }
            // 设定session
            session.setAttribute(userName.toString(), new UserInfo(userName.toString(), password.toString()));
            session.setMaxInactiveInterval(15 * 60);
            // 设置cookie
            CookieUtils.setCookie(request, response, "NE_SHOPPING", userName.toString());
            return true;
        }
        if (!password.toString().equals(userInfo.getPassword())) {
            return false;
        }
        session.setMaxInactiveInterval(15 * 60);
        return true;
    }


}
