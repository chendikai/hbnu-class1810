package com.dingli.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 陈迪凯
 * @date 2020-11-11 15:17
 */
public class UrlDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://127.0.0.1:8080/HelloWorld/index.jsp?username=chendikai&password=123456");

            System.out.println(url.getProtocol()); // 协议
            System.out.println(url.getHost()); // 主机地址
            System.out.println(url.getPort()); // 端口
            System.out.println(url.getFile()); // 文件
            System.out.println(url.getPath()); // 路径
            System.out.println(url.getQuery()); // 参数
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
