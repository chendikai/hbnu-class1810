package com.dingli.jdbc;

import java.util.ResourceBundle;

/**
 * @author 陈迪凯
 * @date 2020-10-20 11:13
 */
public class JavaProgrammer {
    public static void main(String[] args) throws Exception {
//        JdbcInterface jdbcInterface = new MySQLJdbc();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        Class clazz = Class.forName(driver);
        JdbcInterface jdbcInterface = (JdbcInterface) clazz.newInstance();
        jdbcInterface.getConnection();
    }
}
