package com.iza.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/11 9:31
 * description:
 */
public class TimeInterceptor implements HandlerInterceptor {

    //可以使用 ThreadLocal 进行线程间变量的安全使用
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

   // long beginTime;
    //
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler");
       long  beginTime = System.currentTimeMillis();
       //ThreadLocal 存放变量的值
        threadLocal.set(beginTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        long endTime = System.currentTimeMillis();
        Long beginTime = threadLocal.get();
        long time = endTime-beginTime;
        System.out.println("time = " + time);
    }
}
