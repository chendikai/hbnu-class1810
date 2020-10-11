package com.dingli.exception;

import java.io.File;

public class FileException {
    public static void main(String[] args) {
        File file = new File("E:" + File.separator + "Hello.txt");
        if (!file.exists()) {
            try {

                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
