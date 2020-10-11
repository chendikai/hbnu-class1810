package com.dingli.array;

public class Demo04 {
    public static void main(String[] args) {
        int height = 190;
        double salary = 500;
        boolean appearance = true;

        if (height > 180 && salary > 10000000 && appearance == true) {
            System.out.println("直接嫁了");
        } else if (height > 180 || salary > 10000000 || appearance == true) {
            System.out.println("勉强嫁了");
        } else {
            System.out.println("不嫁了");
        }
    }
}
