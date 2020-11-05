package com.dingli.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Tcp 服务端，接收客户端数据
 *
 * @author 陈迪凯
 * @date 2020-11-05 10:11
 */
public class TcpServer01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 1、创建socket服务,并绑定端口
            serverSocket = new ServerSocket(6666);

            // 2、获取socket连接
            socket = serverSocket.accept();  // accept()方法阻塞式方法

            // 3、获取socket输入流，用于接收客户端发送过来的数据
            InputStream in = socket.getInputStream();

            // 4、将数据从输入流中读取出来,并存入字节数组中
            byte[] buf = new byte[1024];
            int len = in.read(buf); // read()方法阻塞式方法

            // 5、处理数据
            System.out.println(new String(buf, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6、关闭资源
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
