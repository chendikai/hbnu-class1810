package com.dingli.InputOutputStream;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {

        // 文件路径
        String fileName = "E:" + File.separator + "DingLi" + File.separator + "jixin1810.txt";

        // 创建文件类对象
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("文件不存在....");
        }
    }
}
