package com.dingli.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 建立一个文本转换服务器，客户端给服务端发送文本数据，
 * 服务端收到数据后将文本转为大写返回给客户端，
 * 客户端可以不断输入文本数据，当客户端输入over时，转换结束
 *
 * @author 陈迪凯
 * @date 2020-11-05 10:55
 */
public class TcpClient03 {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            // 1、创建socket，指定ip和端口port
            socket = new Socket("127.0.0.1", 8888);

            // 2、从键盘输入数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // 3、获取socket输入流和输出流
            // BufferedWriter bufferedOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) { // 4、从键盘读数据
                if ("over".equalsIgnoreCase(line)) {
                    break;
                }

                // 5、向服务端发送数据
                printWriter.println(line);
                // bufferedOut.write(line);
                // bufferedOut.newLine();
                // bufferedOut.flush();

                // 6、接收服务端返回的数据
                String result = bufferedIn.readLine();

                // 7、处理接收端返回的数据
                System.out.println("服务端返回的数据：" + result);

            }
            // 8、关闭资源
            bufferedReader.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
