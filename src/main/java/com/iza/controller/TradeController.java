package com.iza.controller;

import com.github.pagehelper.Page;
import com.iza.common.JsonResult;
import com.iza.entity.User;
import com.iza.service.TradeService;
import com.iza.utils.StrUtils;
import com.iza.vo.VTradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/9 19:38
 * description:
 */

@Controller
@RequestMapping("/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;
    @RequestMapping("/list.do")
    @ResponseBody
    public Map<String,Object> trade(HttpSession session, Date beginTime, Date endTime, Integer page, Integer limit){
        System.out.println(beginTime+"===="+endTime);
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        List<VTradeInfo> list = tradeService.findAllTrade(user.getId(),beginTime,endTime,page, limit);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;

    }

    @RequestMapping("/transfer.do")
    @ResponseBody
    public JsonResult transfer(String otherCode, Double money, HttpSession session) {
        User u = (User)session.getAttribute(StrUtils.LOGIN_USER);
        tradeService.transfer(u.getBankCode(), otherCode, money);
        return new JsonResult(1, "转账成功");
    }


}
