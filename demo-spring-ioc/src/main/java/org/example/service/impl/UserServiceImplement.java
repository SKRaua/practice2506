package org.example.service.impl;

import org.example.dao.UserDAO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * @author Zhou Xinyang
 */
public class UserServiceImplement implements UserService {

    @Autowired // Autowired注入,setter方法要保留
    private UserDAO userDAO;

    public UserServiceImplement() {
    };

    public UserServiceImplement(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void knowName() {
        System.out.println("UserService: 已知UserDAO的名字，开始处理业务。");
        userDAO.getName();
    }

    // 提供对userDAO的set方法，使用setter注入，在application.xml中进行配置
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
