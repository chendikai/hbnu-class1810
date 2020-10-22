package com.dingli.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1、驱动的第二种注册方式
 *
 * @author 陈迪凯
 * @date 2020-10-22 10:03
 */
public class JdbcTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1、注册驱动
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver"); // 第二种方式注册驱动

            // 2、获取连接
            String url = "jdbc:mysql:///hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user = "root";
            String password = "chendikai";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
