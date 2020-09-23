package com.iza.service.impl;

import com.iza.dao.PasswordDao;
import com.iza.entity.Message;
import com.iza.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * projectName:  bankSystem
 *
 * @author: xuwei
 * ime:  2020/9/5 19:31
 * description:
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    PasswordDao passwordDao;
    @Override
    public Message changePassword(Integer id, String oldPassword, String newPassword) {


        String password = passwordDao.selectPasswordByUid(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("oldPassword",newPassword);
        if (password.equals(oldPassword)) {
            //改密码
             passwordDao.updatePasswordById(map);


        }else{
            //输入的密码有误
        }
        return null;
    }
}
