package com.dingli.collection;

/**
 * 定义英雄类
 */
public class Heroes {
    private String id;
    private String name;
    private String role;
    private String sex;

    public Heroes(String id, String name, String role, String sex) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Heroes{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
