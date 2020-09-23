package com.iza.service.impl;

import com.iza.dao.UserDao;
import com.iza.entity.User;
import com.iza.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName:  bankSystem
 *
 * @author: xuwei
 * ime:  2020/9/3 20:13
 * description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    @Override
    public User login(String bankCode, String password) {

        User user = userDao.findByCode(bankCode);
        if (user == null) {
            throw new RuntimeException("账户错误");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return user;

    }

    @Override
    public void updateHeadImg(Integer id, String imgPath) {
        User u = new User();
        u.setId(id);
        u.setImgPath(imgPath);
        userDao.update(u);
    }

    @Override
    public User selectByCode(String bankCode) {

        return userDao.findByCode(bankCode);
    }
}
