package com.netease.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by YukunGeng on 2018/3/13.
 */
@Configuration
public class WebInteceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInteceptor()).addPathPatterns("/**")
                .excludePathPatterns("/get/sessions/**", "/get/index/**", "/js/**", "/css/**", "/static/**", "/myimage/**", "/image/**");
        super.addInterceptors(registry);
    }
}
