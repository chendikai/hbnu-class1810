package com.dingli.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // 多态

        list.add("jixin");
        list.add("1810");
        list.add("hbnu");
        list.add("dingli");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("hbnu".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
