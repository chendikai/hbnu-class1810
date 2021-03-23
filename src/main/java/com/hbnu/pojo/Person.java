package com.hbnu.pojo;

/**
 * @author 陈迪凯
 * @date 2021-03-17 9:01
 */
public class Person {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public Person setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;

        return this;
    }
}
