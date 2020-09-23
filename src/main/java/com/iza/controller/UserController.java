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
 * ime:  2020/9/9 14:33
 * description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult getLoginInfo(HttpSession session){
        User u = (User) session.getAttribute(StrUtils.LOGIN_USER);
        //需要再次从数据库查一遍
        User  user = userService.selectByCode(u.getBankCode());

        JsonResult    jsonResult = new JsonResult(1,user);

        return  jsonResult;
    }
}
