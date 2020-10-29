package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-10-29 10:39
 */
public class RunnableTest {
    public static void main(String[] args) {
        Runnable01 runnable01 = new Runnable01();  // 创建线程对象
        Runnable02 runnable02 = new Runnable02(); // 创建线程对象

        new Thread(runnable01, "奇数线程").start(); // 开启线程
        new Thread(runnable02, "偶数线程").start(); // 开启线程
    }
}
