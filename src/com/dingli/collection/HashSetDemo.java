package com.dingli.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Person> hashSet = new HashSet<>();

        hashSet.add(new Person("后羿",21));
        hashSet.add(new Person("妲己",21));
        hashSet.add(new Person("亚瑟",21));
        hashSet.add(new Person("后羿",21));

        Iterator<Person> iterator = hashSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }
}
