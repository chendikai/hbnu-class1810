package com.hbnu.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陈迪凯
 * @date 2021-03-10 8:14
 */
public class MyBatisTest {

    @Test
    public void findAll() throws IOException {
        // 1、通过mybatis-config.xml核心配置文件构建SqlSessionFactory
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、构建工厂SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 3、通过SqlSessionFactory构建sqlSession对象，用于发送sql语句去执行，获取返回结果
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4、执行sql语句
        String sqlId = "UserMapper.findAll";
        List<User> userList = sqlSession.selectList(sqlId);

        for (User user : userList) {
            System.out.println(user);
        }

    }
}
