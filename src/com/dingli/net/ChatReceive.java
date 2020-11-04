package com.dingli.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 聊天程序接收端线程
 *
 * @author 陈迪凯
 * @date 2020-11-04 15:20
 */
public class ChatReceive implements Runnable {
    private DatagramSocket datagramSocket;

    public ChatReceive(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

                datagramSocket.receive(datagramPacket);

                String ip = datagramPacket.getAddress().getHostAddress();
                String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(ip + ">>>>" + data);
            }
        } catch (Exception e) {
            throw new RuntimeException("接收端接收失败");
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
