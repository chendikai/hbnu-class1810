package com.hbnu.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 陈迪凯
 * @date 2021-03-15 10:25
 */
public class AOPTest {

    @Test
    public void aopTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aopContext.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.insertUser();
    }
}
