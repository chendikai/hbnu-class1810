package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-10-29 11:20
 */
public class Ticket implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
