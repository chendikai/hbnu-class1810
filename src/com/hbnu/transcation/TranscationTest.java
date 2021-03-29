package com.hbnu.transcation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 陈迪凯
 * @date 2021-03-29 8:28
 */
public class TranscationTest {

    @Test
    public void testTranscation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("transcationContext.xml");

        UserService userService = (UserService) context.getBean("userService");

        userService.account();
    }
}
