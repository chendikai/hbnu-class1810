package com.hbnu.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testInsert() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        int rows = sqlSession.insert("UserMapper.insert");

        sqlSession.commit();

        System.out.println("影响的数据行数：" + rows);
    }

    @Test
    public void testUpdate() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        int rows = sqlSession.update("UserMapper.update");

        sqlSession.commit();

        System.out.println("影响的数据行数：" + rows);
    }

    @Test
    public void testDelete() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        int rows = sqlSession.delete("UserMapper.delete");

        sqlSession.commit();

        System.out.println("影响的数据行数：" + rows);
    }

    @Test
    public void testSelectByUsername() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("UserMapper.selectByUsername");

        System.out.println(user);
    }

    @Test
    public void testInsert2() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("铠");
        user.setPassword("123456");
        user.setEmail("kai@qq.com");
        user.setSalary(80000.00);

        int rows = sqlSession.insert("UserMapper.insert2", user);

        sqlSession.commit();

        System.out.println("影响的数据行数：" + rows);
    }

    @Test
    public void testUpdate2() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("chendikai");
        user.setPassword("chendikai");
        int rows = sqlSession.update("UserMapper.update2", user);

        sqlSession.commit();

        System.out.println("影响的数据库行数：" + rows);
    }

    @Test
    public void testDelete2() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        int rows = sqlSession.delete("UserMapper.delete2", "孤独患者");

        sqlSession.commit();

        System.out.println("影响的数据库行数：" + rows);
    }

    @Test
    public void testSelect2() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("UserMapper.select2", "chendikai");

        System.out.println(user);
    }

    @Test
    public void testSelect3() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String, String> map = new HashMap<>();
        map.put("cols", "username, email");
        List<User> userList = sqlSession.selectList("UserMapper.select3", map);

        for (User user : userList) {
            System.out.println(user.getUsername() + ":" + user.getEmail());
        }
    }

    @Test
    public void testSelect4() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String, Double> map = new HashMap<>();
        map.put("minSal", 2000.00);
        map.put("maxSal", 80000.00);

        List<User> userList = sqlSession.selectList("UserMapper.select4", map);

        for (User user : userList) {
            System.out.println(user);
        }
    }
}
