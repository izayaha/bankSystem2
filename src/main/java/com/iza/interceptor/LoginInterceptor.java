package com.iza.interceptor;

import com.iza.entity.User;
import com.iza.utils.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/11 10:47
 * description:
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        //uri  统一资源标识符
        //url  统一资源定位符

        System.out.println("requestURI = " + requestURI);
        User user = (User) request.getSession().getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {
            //如果是ajax请求也得跳转到login.html
            //如果是jquery的ajax，浏览器会带有一个特殊的请求头
            String value = request.getHeader("X-Requested-With");
            if (value != null && value.equals("XMLHttpRequest")) {  //ajax请求
                response.getWriter().write("{\"code\":0,\"info\":\"未登录\"}");

            }else{
                //没有登录，挑转到login.html  非ajax请求的时候直接登录页面
                response.sendRedirect(request.getContextPath()+"/login.html");
            }
            return false;



        }
        return true;
    }
}
