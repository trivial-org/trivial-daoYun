package org.fzu.cs03.daoyun.share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConf implements WebMvcConfigurer {
    @Autowired
    private UserSecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(securityInterceptor).addPathPatterns("/**");//配置登录拦截器拦截路径
        registry.addInterceptor(securityInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/signin")
                .excludePathPatterns("/signup")
                .excludePathPatterns("/verification/mail")
                .excludePathPatterns("/verification/code")
                .excludePathPatterns("/userExist")
                .excludePathPatterns("/device");
//        log.debug("跨域拦截器注册成功！");
    }
}