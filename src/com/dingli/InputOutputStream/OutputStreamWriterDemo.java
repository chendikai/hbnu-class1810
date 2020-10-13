package com.dingli.InputOutputStream;

import java.io.*;

/**
 * 字符输出流转字节输出流
 *
 * 写数据
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "DingLi" + File.separator + "20201013jixin1810.txt";
        // 创建文件类对象
        File file = new File(fileName);

        // 声明一个字符输出流转字节输出流的引用
        OutputStreamWriter outputStreamWriter = null;

        try {
            // 创建字符输出流转字节输出流对象，传入字节输出流对象
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));

            String str = "湖北师范大学计信1810班";

            // 往流通道中写数据
            outputStreamWriter.write(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
