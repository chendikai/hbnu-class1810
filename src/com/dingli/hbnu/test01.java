package com.dingli.hbnu;

public class test01 {

    public static void main(String[] args) {
        int a = 10;
        int b = change(a);
        System.out.println(a);
    }

    public static int change(int a) {
        a *= 2;
        System.out.println(a);
        return a;
    }
}
