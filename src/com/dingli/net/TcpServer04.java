package com.dingli.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 上传文件服务器端
 *
 * @author 陈迪凯
 * @date 2020-11-09 8:15
 */
public class TcpServer04 {
    public static void main(String[] args) {
        try {
            // 1、创建socket服务，并监听端口
            ServerSocket serverSocket = new ServerSocket(8888);

            // 2、获取socket连接
            Socket socket = serverSocket.accept(); // 阻塞式方法
            String ip = socket.getInetAddress().getHostAddress(); // 获取客户端ip
            System.out.println(ip + "...connected......");

            // 3、获取流
            // 获取客户端发送过来的数据的流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 向客户端反馈上传结果的流
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // 将文件保存指定路径的流
            PrintWriter printWriter = new PrintWriter(new FileWriter("E:\\DingLi\\1810.txt"), true);

            // DataInputStream dis = new DataInputStream(socket.getInputStream());
            // long time = dis.readLong();

            // 3、读取客户端发送过来的数据，并将数据写入文件中
            String line = null;
            while ((line= in.readLine()) != null) {
                // if ("over".equals(line)) {
                //     break;
                // }

                // if ((time + "").equals(line)) {
                //     break;
                // }
                // 4、将读到的客户端文件内容写入服务器端文件中
                printWriter.println(line);
            }

            // 5、向客户端反馈上传结果
            out.println("文件上传成功");

            // 6、关闭资源
            printWriter.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
