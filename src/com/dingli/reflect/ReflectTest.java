package com.dingli.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射机制测试
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HouYi houYi = new HouYi("妲己", 18, "200", "法师");
        // 通过类名获取字节码对象
        Class clazz1 = HouYi.class;

        // 调用对象的getClass()方法
        Class clazz2 = houYi.getClass();

        // forName
        Class clazz3 = Class.forName("com.dingli.reflect.HouYi");

        // 通过反射机制获取构造器，并通过构造器创建对象
        Constructor constructor = clazz1.getConstructor(String.class, int.class, String.class, String.class);

        Heroes heroes = (HouYi)constructor.newInstance("后羿", 18, "1000", "射手");
        System.out.println(heroes.getName());

        // 通过字节码对象创建具体的对象
        Heroes heroes1 = (HouYi)clazz3.newInstance();

    }
}
