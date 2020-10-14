package com.dingli.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class HeroesTest {
    public static void main(String[] args) {
        Heroes heroes1 = new Heroes("No.1", "后羿", "射手", "男");
        Heroes heroes2 = new Heroes("No.2", "妲己", "法师", "女");
        Heroes heroes3 = new Heroes("No.3", "亚瑟", "坦克", "男");

        ArrayList<Heroes> arrayList = new ArrayList<>();

        arrayList.add(heroes1);
        arrayList.add(heroes2);
        arrayList.add(heroes3);

        Iterator<Heroes> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
