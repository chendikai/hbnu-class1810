package com.dingli.common;

import java.util.Objects;

public class HouYi {
    private String name;
    private int age;

    public HouYi(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "对象属性name:" + this.name + " ;年龄：" + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        // 判断传入的对象是否为空
        if (obj == null) {
            return false;
        }

        // 传入的对象和当前对象地址值一样
        if (this == obj) {
            return true;
        }

        // 判断传入的对象是否是当前对象类型
        if (!(obj instanceof HouYi)) {
            return false;
        } else {
            HouYi houYi = (HouYi)obj;
            return this.age == houYi.age && this.name.equals(houYi.name);
        }

    }

}
