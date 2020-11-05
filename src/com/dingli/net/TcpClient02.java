package com.dingli.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 实现客户端和服务端的数据交互
 *
 * @author 陈迪凯
 * @date 2020-11-05 10:31
 */
public class TcpClient02 {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            // 1、创建socket服务，指定ip和端口port
            socket = new Socket("127.0.0.1", 6666);

            // 2、获取socket的输入流和输出流
            OutputStream out = socket.getOutputStream(); // socket输出流，用于向服务端发送数据
            InputStream in = socket.getInputStream(); // socket输入流，用于接收服务端返回的数据

            // 3、向服务端发送数据
            out.write("服务端，你在吗？".getBytes());

            // 4、接收服务端返回的数据
            byte[] buf = new byte[1024];
            int len = in.read(buf);

            // 5、处理服务端返回的数据
            System.out.println(new String(buf, 0, len));
        } catch (Exception e) {
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
        }
    }
}
