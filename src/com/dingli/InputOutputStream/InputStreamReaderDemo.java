package com.dingli.InputOutputStream;

import java.io.*;

/**
 * 字节输入流转字符输入流
 *
 * 读数据
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "DingLi" + File.separator + "20201013jixin1810.txt";

        // 创建文件类对象
        File file = new File(fileName);

        // 声明字节输入流转字符输入流引用
        InputStreamReader inputStreamReader = null;

        try {
            // 创建字节输入流转字符输入流对象，传入一个字节输入流对象
            inputStreamReader = new InputStreamReader(new FileInputStream(file));

            // 存储从流中读到的数据
            char[] chars = new char[1024];

            // 开始从流中读数据，读到的数据存入chars数组中
            int length = inputStreamReader.read(chars);

            System.out.println(new String(chars, 0, length));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
