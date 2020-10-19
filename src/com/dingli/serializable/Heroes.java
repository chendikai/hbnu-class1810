package com.dingli.serializable;

import java.io.Serializable;

public class Heroes implements Serializable {

    private static final long serialVersionUID = -8153052231937319390L;
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

    public Heroes(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
