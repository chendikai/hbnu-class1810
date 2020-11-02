package com.dingli.multiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陈迪凯
 * @date 2020-11-02 8:28
 */
public class Account implements Runnable {
    private int money = 0; // 共享数据

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock(); // 加锁
            // 操作共享数据的代码块
            money += 1000;
            System.out.println(Thread.currentThread().getName() + "存入1000元\n" + "当前余额：" + money);
            lock.unlock(); // 释放锁
        }
    }
}
