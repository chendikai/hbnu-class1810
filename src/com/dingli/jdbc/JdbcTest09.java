package com.dingli.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 事务处理机制：银行转账案例
 *
 * @author 陈迪凯
 * @date 2020-10-27 10:55
 */
public class JdbcTest09 {

    public static void main(String[] args) {
        // 获取配置文件中的数据库信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        // 声明变量
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1、注册驱动
            Class.forName(driver);

            // 2、获取连接
            conn = DriverManager.getConnection(url, user, password);

            conn.setAutoCommit(false); // 开启事务

            // 3、获取数据库操作对象
            String sql = "update userinfo set salary = ? where username = ?";
            ps = conn.prepareStatement(sql);

            // 4、执行SQL语句
            ps.setString(1, "5000");
            ps.setString(2, "work");
            int count = ps.executeUpdate();

            ps.setDouble(1, 5000);
            ps.setString(2, "chendikai");
            count += ps.executeUpdate();

            System.out.println("转账成功");

            conn.commit(); // 提交事务
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback(); // 事务回滚
                    System.out.println("转账失败");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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
