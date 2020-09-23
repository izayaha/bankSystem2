package com.iza.servlet;

import com.iza.entity.User;
import com.iza.utils.JsonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet( "/user/query.do")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user != null) {
            JsonUtils.writeJsonInfo(1,user.getBankCode(),response);
        }else{
            JsonUtils.writeJsonInfo(0,null,response);
        }
    }
}
