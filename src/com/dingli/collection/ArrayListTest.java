package com.dingli.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        // 添加元素
        arrayList.add("jixin1810");
        arrayList.add(new Integer(123));  // int -> Integer; 基本数据类型都有对应的包装类
        arrayList.add(null);
        arrayList.add(154.12); // 自动装箱
        System.out.println(arrayList);
        arrayList.add(1, null);
        System.out.println(arrayList);

        System.out.println(arrayList.contains(123));
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.indexOf(123));
        System.out.println(arrayList.isEmpty());
        arrayList.remove(1);
        System.out.println(arrayList);
        arrayList.set(1, 456);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        // for循环遍历集合中的元素
        System.out.println("==========for循环遍历集合元素====================");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        // foreach循环遍历集合元素
        System.out.println("============foreach遍历集合元素===========");
        for (Object obj : arrayList) {
            System.out.println(obj);
        }

        // iterator迭代器遍历集合元素
        System.out.println("==========迭代器遍历集合元素===========");
        Iterator iterator = arrayList.iterator();  // 获取迭代器
        while (iterator.hasNext()) {
            Object element = iterator.next(); // 通过迭代器获取集合中的元素
            System.out.println(element);
        }
    }
}
