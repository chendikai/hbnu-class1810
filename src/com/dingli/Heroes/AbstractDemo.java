package com.dingli.Heroes;

public abstract class AbstractDemo implements InterfaceDemo {
    int num;
    String name;

    public AbstractDemo(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public AbstractDemo() {
    }

    public void run() {

    }

    public abstract void test();
    public abstract void test1();
}
