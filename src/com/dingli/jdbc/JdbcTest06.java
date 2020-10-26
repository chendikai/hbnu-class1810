package com.dingli.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 陈迪凯
 * @date 2020-10-26 9:18
 */
public class JdbcTest06 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2、获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
            String user = "root";
            String password = "chendikai";
            conn = DriverManager.getConnection(url, user, password);

            // 3、获取数据库操作对象
            stmt = conn.createStatement();

            // 4、执行sql语句
            String sql = "select username as name,password,realname,salary from userinfo order by salary desc";
            rs = stmt.executeQuery(sql);
            // 5、处理查询结果集
            while (rs.next()) {
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                String realname = rs.getString("realname");
                String sal = rs.getString("salary");

                System.out.println(name + "\t" + pwd + "\t" + realname + "\t\t" + sal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
