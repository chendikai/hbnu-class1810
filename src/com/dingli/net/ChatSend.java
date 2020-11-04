package com.dingli.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 聊天程序发送端线程
 *
 * @author 陈迪凯
 * @date 2020-11-04 15:13
 */
public class ChatSend implements Runnable {
    private DatagramSocket datagramSocket;

    public ChatSend(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            // 2、从键盘输入数据，并将数据封装到数据报包中
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if ("886".equalsIgnoreCase(line)) {
                    break;
                }

                DatagramPacket datagramPacket = new DatagramPacket(line.getBytes(), line.getBytes().length,
                        InetAddress.getByName("192.168.8.255"), 9999);

                datagramSocket.send(datagramPacket);
            }
        } catch (Exception e) {
            throw new RuntimeException("发送端发送数据失败");
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
