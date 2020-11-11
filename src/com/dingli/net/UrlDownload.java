package com.dingli.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 陈迪凯
 * @date 2020-11-11 15:22
 */
public class UrlDownload {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://m801.music.126.net/20201111155640/6422f26264f2436973e27ba9d31fd576/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/4291026541/31c2/9b7d/5a79/8741db7679f02476af137ae30047d943.m4a");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // 获取socket输入流
            InputStream in = httpURLConnection.getInputStream();

            FileOutputStream fos = new FileOutputStream("E:\\DingLi\\1810.m4a");

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

            fos.close();
            in.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
