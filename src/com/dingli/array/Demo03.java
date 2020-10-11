package com.dingli.array;

public class Demo03 {
    public static void main(String[] args) {
        int a1 = 150;
        int a2 = 165;
        int a3 = 210;

        int temp  = a1 > a2 ? a1 :a2;
        int max = temp > a3 ? temp : a3;

        System.out.println(max);
    }
}
