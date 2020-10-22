package com.dingli.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 从配置文件读取数据库信息，处理查询结果集
 *
 * @author 陈迪凯
 * @date 2020-10-22 10:19
 */
public class JdbcTest03 {

    public static void main(String[] args) {

        // 获取配置文件中的信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        // 声明变量
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1、注册驱动
            Class.forName(driver);
            // 2、获取连接
            conn = DriverManager.getConnection(url, user, password);

            // 3、获取数据库操作对象
            stmt = conn.createStatement();

            // 4、执行sql语句
            String sql = "select username as name,password,realname,salary from userinfo where salary=80000";
            rs = stmt.executeQuery(sql);

            // 5、处理查询结果集
            System.out.println("\t姓名\t\t" + "密码\t\t" + "真实名\t" + "薪水");
            while (rs.next()) {
                /*
                // 5.1 结果以String接收
                String name = rs.getString(1);
                String pwd = rs.getString(2);
                String realname = rs.getString(3);
                String sal = rs.getString(4);
                */

                /*
                // 5.2 结果以数据库中字段的具体类型接收
                String name = rs.getString(1);
                String pwd = rs.getString(2);
                String realname = rs.getString(3);
                double sal = rs.getDouble(4);
                */

                /*
                // 5.3 根据查询的字段名接收数据
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                String realname = rs.getString("realname");
                String sal = rs.getString("salary");
                */

                // 5.4 结果以数据库中字段的具体类型接收和查询的字段名接收数据
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                String realname = rs.getString("realname");
                double sal = rs.getDouble("salary");

                System.out.println(name + "\t" + pwd + "\t" + realname + "\t\t" + sal);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
