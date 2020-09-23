package com.iza.controller;

import com.iza.common.JsonResult;
import com.iza.entity.Message;
import com.iza.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/9 21:51
 * description:
 */
@Controller
public class TransController {
    @Autowired
    private TransService transService;

    @RequestMapping("/trans.do")
    @ResponseBody
    public JsonResult trans(String out ,String in ,String num){
        Message transform = transService.transform(out, in, num);
        JsonResult jsonResult = new JsonResult(1, transform);
        return jsonResult;
    }
}
