package com.dingli.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 发送端
 *
 *  1、建立Udp Socket服务
 *  2、提供数据，并将数据封装到数据报包
 *  3、发送数据
 *  4、关闭连接
 *
 * @author 陈迪凯
 * @date 2020-11-03 11:12
 */
public class UdpSend {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            // 1、建立socket服务
            datagramSocket = new DatagramSocket(9999); // 端口范围：0-65536；0-1024这些端口有固定用途，不建议使用0-1024之间的端口

            // 2、提供数据，封装到数据报包中
            byte[] buf = "Jixin 1810".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8888);

            // 3、发送数据
            datagramSocket.send(datagramPacket);

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
