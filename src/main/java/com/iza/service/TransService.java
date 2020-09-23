package com.iza.service;

import com.iza.entity.Message;

public interface TransService {
    Message transform(String out, String in, String num);
}
