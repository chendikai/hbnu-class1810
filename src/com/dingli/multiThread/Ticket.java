package com.dingli.multiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陈迪凯
 * @date 2020-10-29 11:20
 */
public class Ticket implements Runnable {

    private int ticket = 10; // 线程共享的数据

    private final ReentrantLock lock = new ReentrantLock(); // 拿到锁对象

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock(); // 给操作共享数据的代码加锁
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + ticket);
                ticket--;
            } else {
                break;
            }
            lock.unlock(); // 开锁
        }
    }
}
