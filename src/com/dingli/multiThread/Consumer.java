package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-11-02 9:14
 */
public class Consumer implements Runnable {
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)Math.random() * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product.getProduct();
    }
}
