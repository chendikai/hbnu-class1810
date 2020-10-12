package com.dingli.InputOutputStream;

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "DingLi" + File.separator + "jixin1810.txt";

        File file = new File(fileName);

        // 声明字节输出流
        OutputStream outputStream = null;

        try {
            // 创建文件字节输出流对象
            outputStream = new FileOutputStream(file, true);  // 如果文件不不存在，则创建文件
            String str = "\r\n团支书：许凤莲";

            // 将字符转字节
            byte[] bytes = str.getBytes();

            // 往流中写输入
            // outputStream.write(bytes);

            // 一个字节一个字节的写
            for (int i = 0; i < bytes.length; i++) {
                outputStream.write(bytes[i]);
            }

            System.out.println("写文件完毕......");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                System.out.println("关闭流资源......");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
