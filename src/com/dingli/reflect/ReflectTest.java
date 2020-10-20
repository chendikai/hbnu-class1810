package com.dingli.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制测试
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
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

        // 通过反射获取属性,并操作属性
        Field[] declaredFields = clazz3.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            System.out.print(declaredField.getName() + " ");
        }
        System.out.println();

        Field blood = clazz3.getDeclaredField("blood");
        blood.setAccessible(true);
        blood.set(heroes1, "200");
        String str = (String) blood.get(heroes1);
        System.out.println(str);

        Field role = clazz3.getField("role");
        role.set(heroes1, "射手");
        String r = (String) role.get(heroes1);
        System.out.println(r);

        // 通过反射获取方法，并使用方法
        Method[] declaredMethods = clazz3.getDeclaredMethods(); // 获取本类中所有的方法
        for (int i = 0; i < declaredMethods.length; i++) {
            Method declaredMethod = declaredMethods[i];
            System.out.println(declaredMethod.getName());
        }

        Method method = clazz3.getMethod("bloodReturning");
        method.invoke(heroes1);

        Method declaredMethod = clazz3.getDeclaredMethod("fight");
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(heroes1);
    }
}
