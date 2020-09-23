package com.iza.servlet;

import com.iza.entity.Message;
import com.iza.service.TransService;
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

//@WebServlet("/balance.do")
public class TransServlet extends HttpServlet {
    @Autowired
    TransService transDao ;

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
        String out = request.getParameter("out");
        String in = request.getParameter("in");
        String num = request.getParameter("num");

        Message message = transDao.transform(out,in,num);
        System.out.println("message = " + message.getCode());
        JsonUtils.writeJsonInfo(message.getCode(),message.getInfo(),response);

    }
}
