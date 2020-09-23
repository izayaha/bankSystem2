package com.iza.dao;

import com.iza.entity.User;

public interface UserDao {
    public User findByCode(String bankCode);

    void update(User u);
}
