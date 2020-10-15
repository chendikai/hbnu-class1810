package com.dingli.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("jixin");
        list.add("1808");
        list.add("hbnu");

        Collections.addAll(list, "dingli", "teacher", "chendikai");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list); // 集合的翻转

        System.out.println(Collections.binarySearch(list, "hbnu"));

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

    }
}
