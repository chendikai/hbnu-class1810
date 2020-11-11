package com.dingli.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端通过键盘录入用户名，服务端对用户名进行校验，最多登录三次
 *
 * @author 陈迪凯
 * @date 2020-11-11 14:38
 */
public class TcpServer08Thread implements Runnable {
    private Socket socket;

    public TcpServer08Thread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                // 3、获取流对象
                // socket输入流，用于接收客户端发送过来的数据
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 文件输入流，用于获取文件的内容
                BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\DingLi\\user.txt"));
                // socket输出流，用于向客户端反馈结果
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // 读取用户列表文件，开始校验用户输入的用户名
                String username = in.readLine(); // null
                if (username == null) {
                    break;
                }

                String line = null;
                boolean flag = false;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.equals(username)) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    System.out.println("欢迎" + username + "登录本系统");
                    out.println("欢迎" + username + "登录本系统");
                    break;
                } else {
                    System.out.println("用户" + username + "正在尝试登录本系统");
                    out.println("登录失败");
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
