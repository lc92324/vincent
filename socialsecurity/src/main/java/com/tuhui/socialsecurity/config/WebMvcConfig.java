package com.tuhui.socialsecurity.config;


import com.tuhui.socialsecurity.interceptors.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 *
 * @Description : 拦截器配置
 * @author : lchao
 * @CreateDate : 2019-01-07 11:24:35
 *
 */
@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        //创建拦截对象
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns("/","/login","/error","/static/**","/logout");
    }

}
