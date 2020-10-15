package com.dingli.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Poker {
    public static void main(String[] args) {
        // 1、定义集合存储扑克牌（54张）
        List<String> list = new ArrayList<>();

        // 2、定义数组存储扑克牌的花色
        String[] colorPoker = {"♥", "♠", "♣", "♦"};

        // 3、定义数组存储扑克牌的数字
        String[] numberPoker = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // 4、将扑克牌存入集合
        for (int i = 0; i < colorPoker.length; i++) {
            for (int j = 0; j < numberPoker.length; j++) {
                list.add(colorPoker[i] + numberPoker[j]);
            }
        }
        list.add("🃏King");
        list.add("🃏Queen");

        // 5、洗牌（Collections.shuffle）
        Collections.shuffle(list);
        System.out.println(list);

        // 5、发牌
        List<String> player01 = new ArrayList<>(); // 玩家1的牌
        List<String> player02 = new ArrayList<>(); // 玩家2的牌
        List<String> player03 = new ArrayList<>(); // 玩家3的牌
        List<String> bottom = new ArrayList<>(); // 底牌

        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                bottom.add(list.get(i));
            } else {
                if (i % 3 == 0) {
                    player01.add(list.get(i));
                }
                if (i % 3 == 1) {
                    player02.add(list.get(i));
                }
                if (i % 3 == 2) {
                    player03.add(list.get(i));
                }
            }
        }

        // 6、看每个玩家的牌和底牌
        look("周星驰", player01);
        look("周润发", player02);
        look("刘德华", player03);
        look("底牌", bottom);
    }

    // 上帝视角看牌
    private static void look(String name, List<String> arrayList) {
        System.out.print(name + "::");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
