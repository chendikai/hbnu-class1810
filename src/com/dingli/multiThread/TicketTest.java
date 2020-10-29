package com.dingli.multiThread;

/**
 * @author 陈迪凯
 * @date 2020-10-29 11:23
 */
public class TicketTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}
