package com.dingli.InputOutputStream;

import java.io.*;

public class InputStreamDemo2 {
    public static void main(String[] args) {
        String fileName = "E:" + File.separator + "DingLi" + File.separator + "jixin1810.txt";

        File file = new File(fileName);

        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);

            byte[] bytes = new byte[1024];
            int temp = 0;
            int length = 0;

            while ((temp = inputStream.read()) != -1) {
                bytes[length] = (byte) temp;
                length++;
            }
            System.out.println(new String(bytes, 0, length));

            System.out.println("读文件完毕......");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                System.out.println("关闭流资源......");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
