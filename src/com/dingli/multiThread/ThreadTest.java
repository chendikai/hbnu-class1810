package com.dingli.multiThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程测试类
 *
 * @author 陈迪凯
 * @date 2020-10-28 15:48
 */
public class ThreadTest {
    public static void main(String[] args) {

        // 继承Thread
        MyThread myThread = new MyThread();
        new Thread(myThread).start(); // 启动线程

        System.out.println(myThread.getPriority());

        /*
        // 实现Runnable接口
        // MyRunnable myRunnable = new MyRunnable();
        // new Thread(myRunnable).start(); // 启动线程
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(">>>子线程执行了" + i);
            }
        }).start();
        */

        /*
        // 实现Callable接口
        MyCallable myCallable = new MyCallable();
        FutureTask<String> stringFutureTask = new FutureTask<>(myCallable);
        new Thread(stringFutureTask).start(); // 启动线程

        try {
            String str = stringFutureTask.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        */

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("****主线程执行：" + i);
        }

    }
}
