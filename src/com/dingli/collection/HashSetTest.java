package com.dingli.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("jixin");
        hashSet.add("hbnu");
        hashSet.add("123");
        hashSet.add("hbnu");
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(hashSet);
        System.out.println(hashSet.size());

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
