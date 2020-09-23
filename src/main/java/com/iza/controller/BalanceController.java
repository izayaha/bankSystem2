package com.iza.controller;

import com.iza.common.JsonResult;
import com.iza.entity.User;
import com.iza.service.BalanceService;
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
 * ime:  2020/9/9 22:16
 * description:
 */
@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService;
    @RequestMapping("/balance.do")
    @ResponseBody
    public JsonResult findBalance(HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        Integer id = user.getId();
        Double balance = balanceService.findBalance(id);
        JsonResult jsonResult = new JsonResult(1, balance);
        return jsonResult;
    }
}
