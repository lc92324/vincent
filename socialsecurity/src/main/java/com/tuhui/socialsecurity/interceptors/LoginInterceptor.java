package com.tuhui.socialsecurity.interceptors;

import com.tuhui.socialsecurity.exceptions.MyLoginException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @Description : 自定义拦截器
 * @author : lchao
 * @CreateDate : 2019-01-07
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String cid = request.getHeader("cid");
        if(StringUtils.isEmpty(cid)){
            throw new MyLoginException("非法访问!");
        }else{
            return true;
        }
    }
}
