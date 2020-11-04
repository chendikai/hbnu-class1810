package com.dingli.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP 接收端
 *
 * @author 陈迪凯
 * @date 2020-11-03 11:20
 */
public class UdpReceive {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            // 1、定义socket服务，监听端口
            datagramSocket = new DatagramSocket(8888);

            while (true) {
                // 2、定义数据报包
                byte[] buf = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

                // 3、接收数据
                datagramSocket.receive(datagramPacket); // receive()是一个阻塞式方法

                // 4、取出数据
                String ip = datagramPacket.getAddress().getHostAddress();
                int port = datagramPacket.getPort();
                String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

                System.out.println(ip + ":" + port + ">>>" + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4、关闭连接
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
