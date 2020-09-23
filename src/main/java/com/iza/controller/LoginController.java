package com.iza.controller;

import com.iza.common.JsonResult;
import com.iza.entity.User;
import com.iza.service.UserService;
import com.iza.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/9 14:24
 * description:
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String bankCode, String password, HttpSession session){
        User user = userService.login(bankCode, password);
        session.setAttribute(StrUtils.LOGIN_USER,user);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }
}
