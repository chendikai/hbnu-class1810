package com.hbnu.dao;

import com.hbnu.pojo.User;

/**
 * @author 陈迪凯
 * @date 2021-03-31 9:08
 */
public interface UserMapper {

    public User findUserByUsername(String username);
}
