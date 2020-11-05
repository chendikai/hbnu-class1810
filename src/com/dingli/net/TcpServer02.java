package com.dingli.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现客户端和服务端的数据交互
 *
 * @author 陈迪凯
 * @date 2020-11-05 10:38
 */
public class TcpServer02 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 1、创建ServerSocket服务，并监听端口
            serverSocket = new ServerSocket(6666);

            // 2、获取socket连接
            socket = serverSocket.accept();

            // 3、获取socket的输入流和输出流
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // 4、接收客户端发送过来的数据
            byte[] buf = new byte[1024];
            int len = in.read(buf);

            // 5、处理客户端发送过来的数据
            System.out.println(new String(buf, 0, len));

            // 6、向客户端反馈数据
            out.write("客户端，我这呢".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7、关闭资源
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
