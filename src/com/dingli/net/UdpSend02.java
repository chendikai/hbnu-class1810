package com.dingli.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 从键盘输入数据，发送给接收端
 * 
 * @author 陈迪凯
 * @date 2020-11-04 14:34
 */
public class UdpSend02 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            // 1、建立UDP socket服务
            datagramSocket = new DatagramSocket(6666);

            // 2、从键盘输入数据，并将数据封装到数据报包中
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            // 开始读从键盘输入的数据
            while ((line = buf.readLine()) != null) {
                if ("bye".equalsIgnoreCase(line)) {
                    break;
                }

                byte[] bytes = line.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 8888);

                // 3、将封装后的数据报包发送出去
                datagramSocket.send(datagramPacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4、关闭socket服务
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }


    }
}
