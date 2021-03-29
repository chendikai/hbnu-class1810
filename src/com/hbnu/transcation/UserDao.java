package com.hbnu.transcation;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 陈迪凯
 * @date 2021-03-29 8:12
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void lessMoney() {
        String sql = "update tb_account set account = account - ? where username = ?";
        jdbcTemplate.update(sql, 1000.00, "zhangsan");
    }

    public void moreMoney() {
        String sql = "update tb_account set account = account + ? where username = ?";
        jdbcTemplate.update(sql, 1000.00, "lisi");
    }
}
