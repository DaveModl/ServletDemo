package com.login.exec.service.impl;

import com.login.exec.dao.LoginDao;
import com.login.exec.dao.impl.LoginDaoImpl;
import com.login.exec.model.User;
import com.login.exec.service.LoginService;

public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    @Override
    public User selectUser(String username, String password) {
        //TODO 后端的二次校验
        return loginDao.checkUser(username,password);
    }

    @Override
    public User checkUserById(Integer userId) {
        return loginDao.checkUserById(userId);
    }
}
