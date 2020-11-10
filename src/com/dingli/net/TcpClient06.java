package com.dingli.net;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 图片上传
 *
 * @author 陈迪凯
 * @date 2020-11-10 10:09
 */
public class TcpClient06 {
    public static void main(String[] args) {
        try {
            // 1、创建socket服务，指定服务器端ip和端口port
            Socket socket = new Socket("127.0.0.1", 8888);

            // 2、获取流对象
            // 图片文件输入流，用于获取图片文件内容
            FileInputStream fis = new FileInputStream("C:\\Users\\chend\\Desktop\\washing.jpg");
            // socket输出流，用于向服务器端发送数据
            OutputStream out = socket.getOutputStream();
            // socket输入流，用于接收服务器端返回的结果
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 3、获取图片内容，并将图片内容上传至服务器端
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                // 4、将图片内容上传至服务器端
                out.write(buf, 0, len);
            }

            socket.shutdownOutput(); // 发送结束标记

            // 5、获取服务器端返回的结果
            String result = in.readLine();
            System.out.println(result);

            // 6、关闭资源
            fis.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
