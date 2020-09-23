package com.iza.service.impl;

import com.iza.dao.TransDao;

import com.iza.entity.Message;
import com.iza.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * projectName:  bankSystem
 *
 * @author: xuwei
 * ime:  2020/9/5 15:14
 * description:
 */
@Service
public class TransServiceImpl implements TransService {
    @Autowired
    TransDao transDao ;
    @Override
    public Message transform(String out, String in, String num) {

        Map<String,String> map = new HashMap<>();
        map.put("out",out);
        map.put("in",in);
        map.put("num",num);
        Message message = new Message();
        try{
            int ct = transDao.updateAddMoney(map);
            int ct2 = transDao.updateSubMoney(map);
            System.out.println("ct = " + ct);
            System.out.println("ct2 = " + ct2);
            message.setCode(1);
            message.setInfo("转账成功");
        }catch (Exception e){
            message.setCode(0);
            message.setInfo("转账失败");
            throw e;

        }

        return message;
    }
}
