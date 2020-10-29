package com.dingli.multiThread;

/**
 * 线程的实现方式二：实现Runnable接口
 *
 * @author 陈迪凯
 * @date 2020-10-29 10:07
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">>>子线程执行了" + i);
        }
    }
}
