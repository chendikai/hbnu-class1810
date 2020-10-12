package com.dingli.InputOutputStream;

import java.io.File;
import java.io.IOException;

public class CreateDeleteFile {
    public static void main(String[] args) {
        // 文件路径
        String fileName = "E:" + File.separator + "DingLi" + File.separator + "jixin1810.txt";

        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
            System.out.println("文件删除成功......");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件创建失败.....");
            }
        }
    }
}
