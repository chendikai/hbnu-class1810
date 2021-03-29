package com.hbnu.jdbcTemplate.c3p0;

import com.hbnu.jdbcTemplate.c3p0.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 陈迪凯
 * @date 2021-03-22 9:26
 */
public class C3p0Test {

    @Test
    public void c3p0Test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplateContext.xml");

        UserService userService = (UserService) context.getBean("userService");

        userService.add();
    }
}