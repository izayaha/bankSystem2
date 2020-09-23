package com.iza.servlet;

import com.iza.entity.User;
import com.iza.service.UserService;
import com.iza.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/login.do")
public class LoginServlet extends  HttpServlet {
    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //让loginServlet支持 依赖注入
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String bankCode = request.getParameter("bankCode");
        String password = request.getParameter("password");
        System.out.println("password = " + password);

        try {
            User user = userService.login(bankCode, password);
            request.getSession().setAttribute("loginUser",user);
            System.out.println("success");
            JsonUtils.writeJsonInfo(1,null,response);

        }catch(Exception e){
            e.printStackTrace();
            JsonUtils.writeJsonInfo(0,e.getMessage(),response);
        }

    }
}
