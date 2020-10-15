package com.dingli.collection;


import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        // 添加元素
        hashMap.put(1, "jixin");
        hashMap.put(1, "1810");
        hashMap.put(2, "hbnu");
        hashMap.put(3, "dingli");

        Set<Integer> integers = hashMap.keySet(); // 获取map集合中的key
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key + "： " + value);
        }

        Collection<String> values = hashMap.values(); // 获取集合中的值
        Iterator<String> iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> next = iterator1.next();
            System.out.println(next.getKey() + ": " + next.getValue());
        }

    }
}
