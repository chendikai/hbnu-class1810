package com.hbnu.jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author 陈迪凯
 * @date 2021-03-22 8:09
 */
public class JdbcTemplateTest {

    @Test
    public void insertUser() {
        // 1、配置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("chendikai");

        // 2、创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 3、通过jdbcTemplate对象执行数据库的crud操作
        String sql = "insert into tb_user values(?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, "计信1810", "123456", "jixin@163.com", 80000.00);
        System.out.println("影响数据库行数：" + rows);
    }

    @Test
    public void updateUser() {
        // 1、配置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("chendikai");

        // 2、创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 3、通过jdbcTemplate对象执行修改操作
        String sql = "update tb_user set password = ? where username = ?";
        int rows = jdbcTemplate.update(sql, "987654", "计信1810");
        System.out.println("影响数据库行数：" + rows);
    }

    @Test
    public void deleteUser() {
        // 1、配置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("chendikai");

        // 2、创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 3、通过jdbcTemplate对象执行修改操作
        String sql = "delete from tb_user where username = ?";
        int rows = jdbcTemplate.update(sql, "计信1810");
        System.out.println("影响数据库行数：" + rows);
    }

    @Test
    public void selectUser1() {
        // 1、配置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("chendikai");

        // 2、创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 3、通过jdbcTemplate对象执行修改操作
        String sql = "select count(*) from tb_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("数据库表总共有" + count + "条记录");
    }

    @Test
    public void selectUser2() {
        // 1、配置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("chendikai");

        // 2、创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 3、通过jdbcTemplate对象执行修改操作
        String sql = "select * from tb_user where username = ?";
        User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "chendikai");
        System.out.println(user);

    }

    @Test
    public void selectUser3() {
        // 1、配置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hbnu?serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("chendikai");

        // 2、创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 3、通过jdbcTemplate对象执行修改操作
        String sql = "select * from tb_user";
        List<User> userList = jdbcTemplate.query(sql, new MyRowMapper());

        for (User user : userList) {
            System.out.println(user);
        }

    }
}
