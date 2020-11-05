package com.dingli.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 需求：发送一次数据给服务端
 *
 * @author 陈迪凯
 * @date 2020-11-05 10:03
 */
public class TcpClient01 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // 1、创建socket
            socket = new Socket("127.0.0.1", 6666);

            // 2、获取socket的输出流,用于发送数据到服务端
            OutputStream out = socket.getOutputStream();

            // 3、发送数据
            byte[] buf = "hbnu jixin 1810".getBytes();
            out.write(buf);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭资源
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
