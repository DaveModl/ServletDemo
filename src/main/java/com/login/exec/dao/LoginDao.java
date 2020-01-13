package com.login.exec.dao;

import com.login.exec.model.User;

public interface LoginDao {
    User checkUser(String username,String password);
    User checkUserById(Integer id);
}
