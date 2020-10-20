package com.dingli.jdbc;

/**
 * 模拟MySQL数据库厂商
 *
 * @author 陈迪凯
 * @date 2020-10-20 11:10
 */
public class MySQLJdbc implements JdbcInterface {
    @Override
    public void getConnection() {
        System.out.println("成功连接MySQL数据库......");
    }
}
