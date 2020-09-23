package com.iza.controller;

import com.iza.common.JsonResult;
import com.iza.entity.Message;
import com.iza.entity.User;
import com.iza.service.PasswordService;
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
 * ime:  2020/9/9 21:43
 * description:
 */
@Controller

public class PasswordController {
    @Autowired
    private PasswordService passwordService ;

    @RequestMapping("/change.do")
    @ResponseBody
    public JsonResult change(String oldPassword, String newPassword, HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        System.out.println("newPassword = " + newPassword);
        System.out.println("oldPassword = " + oldPassword);
        Integer userId = user.getId();
        Message message = passwordService.changePassword(userId, oldPassword, newPassword);
        JsonResult jsonResult = new JsonResult(1, message);
        return jsonResult;

    }
}
