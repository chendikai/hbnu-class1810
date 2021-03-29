package com.hbnu.transcation;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author 陈迪凯
 * @date 2021-03-29 8:13
 */
@Transactional  // 事务注解
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 转账业务
    public void account() {
        userDao.lessMoney();

        int num = 100/0;

        userDao.moreMoney();
    }
}
