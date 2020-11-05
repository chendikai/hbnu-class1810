package com.dingli.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 建立一个文本转换服务器，客户端给服务端发送文本数据，
 * 服务端收到数据后将文本转为大写返回给客户端，
 * 客户端可以不断输入文本数据，当客户端输入over时，转换结束
 *
 * @author 陈迪凯
 * @date 2020-11-05 11:07
 */
public class TcpServer03 {
    public static void main(String[] args) {
        try {
            // 1、创建server socket服务，并监听端口
            ServerSocket serverSocket = new ServerSocket(8888);

            // 2、获取socket连接
            Socket socket = serverSocket.accept();

            // 3、获取socket输入流和输出流
            BufferedReader bufferedIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // BufferedWriter bufferedOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            byte[] buf = new byte[1024];
            String line = null;
            while ((line = bufferedIn.readLine()) != null) { // 4、获取客户端发送过来的数据
                System.out.println(line);
                // 5、将客户端发送过来的数据转为大写后再并发送给客户端
                // bufferedOut.write(line.toUpperCase());
                // bufferedOut.newLine();
                // bufferedOut.flush();
                printWriter.println(line.toUpperCase());
            }
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
