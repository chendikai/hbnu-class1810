package com.dingli.InputOutputStream;

import java.io.File;
import java.io.IOException;

public class CreteFile {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "DingLi" + File.separator + "jixin1810.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("文件创建成功......");
            } catch (IOException e) {
                System.out.println("文件创建失败......");
                e.printStackTrace();
            }
        }
    }
}
