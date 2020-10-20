package com.dingli.jdbc;

/**
 * 模拟Oracle数据库厂商
 *
 * @author 陈迪凯
 * @date 2020-10-20 11:11
 */
public class OracleJdbc implements JdbcInterface {
    @Override
    public void getConnection() {
        System.out.println("成功连接Oracle数据库......");
    }
}
