package com.hbnu.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 陈迪凯
 * @date 2021-03-09 17:21
 */
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public void printUserService() {
        System.out.println("UserService......printUserService......");
        userDao.printUserDao();
    }
}
