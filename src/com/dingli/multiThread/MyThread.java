package com.dingli.multiThread;

/**
 * 线程创建方式一：继承Thread类
 *
 * @author 陈迪凯
 * @date 2020-10-28 15:46
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程执行：" + i);
        }
    }
}
