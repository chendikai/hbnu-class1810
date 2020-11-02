package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-11-02 9:04
 */
public class Product {
    private int products = 0; // 共享数据

    // 添加商品
    public synchronized void addProduct() {
        while (true) {
            if (products >= 20) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                products++;
                System.out.println("生产者生产了" + products + "号商品");
                notifyAll();
            }
        }
    }

    // 消费商品
    public synchronized void getProduct() {
        while (true) {
            if (products <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("消费者消费了" + products + "号商品");
                products--;
                notifyAll();
            }
        }
    }
}
