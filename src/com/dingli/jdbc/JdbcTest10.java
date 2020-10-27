package com.dingli.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用JDBC工具类实现模糊查询
 *
 * @author 陈迪凯
 * @date 2020-10-27 11:29
 */
public class JdbcTest10 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection(); // 获取配置文件中的数据库信息、注册驱动、获取连接

            // 获取数据库操作对象
            String sql = "select username,password,salary from userinfo where username like ?";
            ps = conn.prepareStatement(sql);

            // 执行sql语句
            ps.setString(1, "_o%");
            rs = ps.executeQuery();

            // 处理查询结果集
            while (rs.next()) {
                String name = rs.getString("username");
                String pwd = rs.getString("password");
                String sal = rs.getString("salary");
                System.out.println(name + "\t" + pwd + "\t" + sal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
    }
}
