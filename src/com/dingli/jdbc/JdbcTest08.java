package com.dingli.jdbc;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示JDBC事务自动提交机制
 *
 * @author 陈迪凯
 * @date 2020-10-27 10:40
 */
public class JdbcTest08 {

    public static void main(String[] args) {
        // 获取配置文件中的数据库信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        // 变量声明
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1、注册驱动
            Class.forName(driver);

            // 2、获取连接
            conn = DriverManager.getConnection(url, user, password);

            // 3、获取数据库操作对象
            String sql = "update userinfo set salary = ? where username = ?";
            ps = conn.prepareStatement(sql);

            // 4、执行sql语句
            ps.setDouble(1, 3600);
            ps.setString(2, "11111");
            int count = ps.executeUpdate();

            String str = null;
            str.length();

            ps.setDouble(1, 400);
            ps.setString(2, "hahahaha");
            count += ps.executeUpdate();

            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            try {
                if (ps != null) {
                    ps.close();
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
