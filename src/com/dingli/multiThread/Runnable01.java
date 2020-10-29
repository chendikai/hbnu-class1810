package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-10-29 10:36
 */
public class Runnable01 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 100; i+=2) {
            System.out.println(Thread.currentThread().getName() + "-->：" + i);
        }
    }
}
