package com.dingli.hbnu;

public class Overriding {

    public static void main(String[] args) {

    }

    public void sum(int a, double b) {
        System.out.println("sum:" + (a + b));
    }

    public void sum(double b, int a) {
        System.out.println("sum:" + (a + b));
    }

    public void sum(float a, float b) {
        System.out.println("sum:" + (a + b));
    }

    public void sum(int a, int b, int c) {

    }


}
