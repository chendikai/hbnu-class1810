package com.dingli.multiThread;

/**
 * 线程测试类
 *
 * @author 陈迪凯
 * @date 2020-10-28 15:48
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start(); // 启动线程

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程执行：" + i);
        }

    }
}
