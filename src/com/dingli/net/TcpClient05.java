package com.dingli.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 序列化对象，通过网络进行传输
 *
 * @author 陈迪凯
 * @date 2020-11-09 9:16
 */
public class TcpClient05 {
    public static void main(String[] args) {
        try {
            // 1、创建socket服务，指定服务器端ip和端口port
            Socket socket = new Socket("127.0.0.1", 8888);

            // 2、获取流
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); // 向服务器端发送对象
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 获取服务器端返回的结果

            // 3、上传对象
            User user = new User();
            user.setName("jixin1810");
            user.setAge(18);
            out.writeObject(user);

            // 4、获取服务器端返回的结果
            String result = in.readLine();
            System.out.println(result);

            // 5、关闭资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
