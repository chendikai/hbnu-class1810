package com.dingli.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 从数据中查询数据并进行封装
 *
 * @author 陈迪凯
 * @date 2020-10-28 14:50
 */
public class JdbcTest13 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1、注册驱动和获取连接
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            // 3、获取数据库操作对象
            String sql = "select id, username, password, realname, salary from userinfo";
            ps = conn.prepareStatement(sql);

            // 4、执行SQL语句
            rs = ps.executeQuery();

             List<User> list = new ArrayList<>();
            // 5、处理查询结果集
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRealname(rs.getString("realname"));
                user.setSalary(rs.getDouble("salary"));

                list.add(user);
            }

            conn.commit(); // 提交事务

            /*
             *  1、循环次数.for + 回车
             *  2、fori + 回车   ----> 普通for循环
             *  3、itar + 回车   ----> 数组for循环
             *  4、iter + 回车   ----> 增强for循环
             *  5、itli + 回车   ----> 集合for循环
             */

            Iterator<User> iterator = list.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                System.out.println(user.getUsername() + "\t" + user.getSalary());
            }

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 6、释放资源
            JDBCUtils.close(rs, ps, conn);
        }
    }
}
