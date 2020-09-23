package com.iza.controller;

import com.iza.common.JsonResult;
import com.iza.entity.User;
import com.iza.service.UserService;
import com.iza.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/10 20:40
 * description:
 */
@Controller
public class UploadController {
    @Autowired
    private UserService userService;

    @RequestMapping("/upload.do")
    @ResponseBody
    public JsonResult uploadFile(@RequestParam(value="file") MultipartFile upfile, HttpSession session){
        User u = (User) session.getAttribute(StrUtils.LOGIN_USER);
        if (u == null) {
            return new JsonResult(0, "未登录");
        }
            String dir = "d:/upload";
            String filename = upfile.getOriginalFilename();
            System.out.println("filename = " + filename);
            File dirFile = new File(dir);
            if (!dirFile.exists()) {
                dirFile.mkdir();
            }
            File newFile = new File(dir, filename);
            try {
                upfile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            userService.updateHeadImg(u.getId(),"/upload/"+filename);
            return new JsonResult(1,"上传成功");
        }
    }

