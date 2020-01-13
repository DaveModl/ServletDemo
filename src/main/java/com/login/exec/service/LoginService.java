package com.login.exec.service;

import com.login.exec.model.User;

public interface LoginService {
    User selectUser(String username,String password);

    User checkUserById(Integer userId);
}
