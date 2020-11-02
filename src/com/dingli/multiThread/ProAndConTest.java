package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-11-02 9:16
 */
public class ProAndConTest {
    public static void main(String[] args) {
        Product product = new Product();

        Productor productor = new Productor(product); // 生产者线程
        Consumer consumer = new Consumer(product); // 消费者线程

        new Thread(productor).start(); // 启动生产主线程
        new Thread(consumer).start(); // 启动消费者线程

    }
}
