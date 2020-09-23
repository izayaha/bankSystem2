package com.iza.dao;

import java.util.HashMap;

public interface PasswordDao {
 public   String selectPasswordByUid(Integer id);

 public   void updatePasswordById(HashMap<String, Object> map);
}
