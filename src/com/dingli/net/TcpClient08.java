package com.dingli.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端通过键盘录入用户名，服务端对用户名进行校验，最多登录三次
 *
 * @author 陈迪凯
 * @date 2020-11-11 14:28
 */
public class TcpClient08 {
    public static void main(String[] args) {
        try {
            // 1、创建socket服务，并指定服务器端的ip和端口
            Socket socket = new Socket("127.0.0.1", 6666);

            // 2、获取流对象
            // 键盘输入流，用于获取键盘输入的字符
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // socket输出流，用于向服务器端发送数据
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // socket输入流，用于接收服务器端返回的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 读键盘数据，并将键盘数据发送给服务器端
            for (int i = 0; i < 3; i++) {
                // 3、获取键盘数据
                String name = bufferedReader.readLine();
                if (name == null) {
                    break;
                }

                // 4、发送数据给服务器端
                out.println(name);

                // 5、获取服务器端返回的结果
                String result = in.readLine();
                System.out.println(result);

                if (result.contains("欢迎")) {
                    break;
                }
            }

            // 6、关闭资源
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
