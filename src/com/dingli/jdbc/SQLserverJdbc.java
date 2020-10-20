package com.dingli.jdbc;

/**
 * 模拟SQL server数据库厂商
 *
 * @author 陈迪凯
 * @date 2020-10-20 11:12
 */
public class SQLserverJdbc implements JdbcInterface {
    @Override
    public void getConnection() {
        System.out.println("成功连接SQL server数据库......");
    }
}
