package com.iza.service;

import com.iza.entity.User;

public interface UserService {
    public User login(String bankCode, String password);

    void updateHeadImg(Integer id, String s);
    public User selectByCode(String bankCode);
}
