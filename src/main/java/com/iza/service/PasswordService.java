package com.iza.service;

import com.iza.entity.Message;

public interface PasswordService {
    Message changePassword(Integer id, String oldPassword, String newPassword);
}
