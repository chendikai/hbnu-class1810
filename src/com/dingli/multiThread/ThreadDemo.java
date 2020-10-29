package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-10-29 11:01
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ">>>");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        System.out.println(threadDemo.getPriority());
        threadDemo.setName("演示线程");
        threadDemo.setPriority(9);

        System.out.println(threadDemo.getPriority());

        threadDemo.start();
    }
}
