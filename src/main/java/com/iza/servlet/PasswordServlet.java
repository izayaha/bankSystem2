package com.iza.servlet;

import com.iza.entity.Message;
import com.iza.entity.User;
import com.iza.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/change.do")
public class PasswordServlet extends HttpServlet {
    @Autowired
   private PasswordService passwordService ;
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
        User user = (User) request.getSession().getAttribute("loginUser");
        Integer id = user.getId();
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        Message message = passwordService.changePassword(id,oldPassword,newPassword);
    }
}
