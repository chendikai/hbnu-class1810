package com.dingli.net;

import java.io.Serializable;

/**
 * @author 陈迪凯
 * @date 2020-11-09 9:14
 */
public class User implements Serializable {
    private static final long serialVersionUID = 8235971825289359033L;

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
