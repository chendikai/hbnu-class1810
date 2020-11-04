package com.dingli.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 陈迪凯
 * @date 2020-11-04 15:24
 */
public class Chat {
    public static void main(String[] args) {

        try {
            DatagramSocket sendSocket = new DatagramSocket();
            DatagramSocket receiveSocket = new DatagramSocket(9999);

            new Thread(new ChatSend(sendSocket)).start();
            new Thread(new ChatReceive(receiveSocket)).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
