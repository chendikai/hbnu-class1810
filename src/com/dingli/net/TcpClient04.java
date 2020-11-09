package com.dingli.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 文本文件上传客户端
 *
 * @author 陈迪凯
 * @date 2020-11-09 8:02
 */
public class TcpClient04 {
    public static void main(String[] args) {
        try {
            // 1、创建socket服务，指定服务器端ip和端口port
            Socket socket = new Socket("127.0.0.1", 8888);

            // 2、获取流
            // 获取文件读取流，读取文件内容
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(".\\src\\jdbc.properties")));
            // 向服务器端发送数据
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //  接收服务器端返回的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            // Long time = System.currentTimeMillis(); // 获取当前时间戳
            // dos.writeLong(time); // 告诉服务器结束标记

            // 3、开始读需要上传的文件内容，并将内容发送给服务器端
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                // 4、将内容发送给服务器端
                out.println(line);
            }
            // out.println("over");
            // out.println(time + "");
            socket.shutdownOutput();

            // 5、接收服务器端返回的数据
            String result = in.readLine(); // 服务器端返回的结果
            System.out.println(result);

            // 6、关闭资源
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
