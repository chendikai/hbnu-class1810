package com.dingli.multiThread;

import java.util.concurrent.Callable;

/**
 * 线程的实现方式三：实现Callable接口
 *
 * @author 陈迪凯
 * @date 2020-10-29 10:20
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep((int)Math.random() * 100 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">>>子线程执行了" + i);
        }
        return "callable接口";
    }
}
