<h1 align="center">J2EE高级开发框架</h1>

#### 一、Spring框架简介

- Spring框架是一个免费的、开源的、轻量级应用程序开发框架，其目的是为了==简化==企业级应用程序的开发，==降低==开发者的开发难度
- Spirng框架提供了AOP和IOC应用，其目的是将应程序之间的模块进行==解耦合==
- Spring框架提供了一整套解决方案，开发者可以使用其自身的功能，也可以看整合第三方优秀框架或技术，开发中具体使用哪种技术可以自由选择

#### 二、Spring框架优势

- 方便解耦，简化开发
- AOP编程支持
- 声明式事务支持
- 降低J2EE中api的使用难度
- 方便整合其他优秀框架

==一句话概括：Spring框架的本质是管理软件中的对象，即对象的创建和维护对象之间的关系==

#### 三、Spring框架的架构

​		Spring框架最初的目的是为了整合一切优秀资源，然后对外提供统一的服务。Spring模块构建在核心容器之上，核心容器定义了创建、存储和管理bean的方式，如图所示：

![Spring模块组成](E:\湖师鼎利学院\202101\J2EE高级开发框架\Spring模块组成.png)

​		说明：Spring模块每一个可以单独存在和使用，也可以联合一个或多个模块进行开发。各个模块的功能如下：

![Spring模块功能](E:\湖师鼎利学院\202101\J2EE高级开发框架\Spring模块功能.png)

#### 四、Spring框架的IOC（重点）

##### 1、IOC概述

​		IOC（控制反转），传统方式对象的创建需要通过关键字new进行，在Spring框架中，不再使用关键字new创建对象，而是将对象的创建、存储和管理交给Spring，IOC通过xml配置文件或者注解实现这种功能。IOC底层使用到的技术：xml配置文件、dom4j解析xml文件、工厂设计模式、反射。

##### 2、IOC底层原理分析

![IOC原理-01](E:\湖师鼎利学院\202101\J2EE高级开发框架\IOC原理-01.png)

上述过程仍有耦合度

![IOC原理-02](E:\湖师鼎利学院\202101\J2EE高级开发框架\IOC原理-02.png)

##### 3、IOC入门案例

1. 导入jar包

    [Spring框架下载](https://repo.spring.io/release/org/springframework/spring/)

    创建普通的web项目，导入Spring框架核心jar包，项目结构如下：

    ![image-20210302112812650](C:\Users\chend\AppData\Roaming\Typora\typora-user-images\image-20210302112812650.png)

2. 创建普通类User.java

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:03
     */
    public class User {
        public void add() {
            System.out.println("IOC test......");
        }
    }
    ```

3. 创建配置文件

    Spring核心配置文件路径和名称没有固定要求，官方建议：配置文件放到src目录下，配置文件名称applicationContext.xml 

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <bean id="user" class="com.hbnu.entity.User" />
    </beans>
    ```

4. 测试IOC

    ```java
    package com.hbnu.entity;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:11
     */
    public class IOCTest {
    
        @Test
        public void userTest() {
            // 1、加载spring核心配置文件
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
            /// 2、获取bean对象
            User user = (User) applicationContext.getBean("user");
    
            user.add();
        }
    }
    ```

##### 4、IOC底层api

![IOC底层api](C:\Users\chend\AppData\Roaming\Typora\typora-user-images\image-20210302173107270.png)

##### 5、IOC初始化过程

![IOC底层过程](C:\Users\chend\AppData\Roaming\Typora\typora-user-images\image-20210302174315322.png)

------

#### 五、Spring中的Bean管理

​		Spring中Bean管理的方式：通过无参构造函数（==重点==）、通过静态工厂（了解）、通过实例工厂（==了解==）

##### 1、通过无参构造函数

- 创建User类

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:03
     */
    public class User {
        public void add() {
            System.out.println("IOC test......");
        }
    }
    ```

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <bean id="user" class="com.hbnu.entity.User"/>
    </beans>
    ```

##### 2、通过静态工厂创建Bean对象

- 创建工厂

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 8:14
     */
    public class UserFactory {
        
        public static User getUser() {
            return new User();
        }
    }
    ```

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <!--<bean id="user" class="com.hbnu.entity.User"/>-->
        
        <!-- 通过静态工厂管理Bean对象 -->
        <bean id="factory" class="com.hbnu.entity.UserFactory" factory-method="getUser"></bean>
    </beans>
    ```

- 测试

    ```java
    package com.hbnu.entity;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:11
     */
    public class IOCTest {
    
        @Test
        public void userTest() {
            // 1、加载spring核心配置文件
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
            /// 2、获取bean对象
            User user = (User) applicationContext.getBean("factory");
    
            user.add();
        }
    }
    ```

##### 3、通过实例工厂创建Bean对象

- 创建工厂类

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 8:14
     */
    public class UserFactory {
    
        public User getUser() {
            return new User();
        }
    }
    ```

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <!--<bean id="user" class="com.hbnu.entity.User"/>-->
    
        <!-- 通过静态工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory" factory-method="getUser"></bean>-->
    
        <!-- 通过实例工厂管理Bean对象 -->
        <bean id="factory" class="com.hbnu.entity.UserFactory"></bean>
        <bean id="user" factory-bean="factory" factory-method="getUser"></bean>
    </beans>
    ```

- 测试

    ```java
    package com.hbnu.entity;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:11
     */
    public class IOCTest {
    
        @Test
        public void userTest() {
            // 1、加载spring核心配置文件
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
            /// 2、获取bean对象
            User user = (User) applicationContext.getBean("user");
    
            user.add();
        }
    }
    ```

#### 六、Spring中Bean标签常见属性

![image-20210303154701901](C:\Users\chend\AppData\Roaming\Typora\typora-user-images\image-20210303154701901.png)

**Scope属性：**

1. singleton：单例的，Spring容器只会创建一个Bean对象
2. prototype：多例的，Spring容器创建多个Bean对象
3. request：在WEB项目中，Spring创建Bean对象，将Bean对象存入request域
4. session：在WEB项目中，Spring创建Bean对象，将Bean对象存入session域
5. globalSession：在WEB项目中，基于Porlet环境（基于java的web组件）创建Bean，如果没有Porlet环境，那么就跟session一样

#### 七、属性注入

​		创建对象的过程中，给类中的属性设置值。属性注入有三种方式：通过有参构造函数、通过set方法（==重点==）、通过接口注入（Spring框架不支持）

![image-20210308090540559](C:\Users\chend\AppData\Roaming\Typora\typora-user-images\image-20210308090540559.png)

##### 1、通过构造函数注入属性

- 创建User类

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:03
     */
    public class User {
        private String username;
    
        public User(String username) {
            this.username = username;
        }
    
        public void add() {
            System.out.println("add......" + username);
        }
    }
    ```

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <!--<bean id="user" class="com.hbnu.entity.User"/>-->
    
        <!-- 通过静态工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory" factory-method="getUser"></bean>-->
    
        <!-- 通过实例工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory"></bean>
        <bean id="user" factory-bean="factory" factory-method="getUser"></bean>-->
        
        <!-- 属性注入 -->
        <!-- 通过有参构造函数注入属性 -->
        <bean id="user" class="com.hbnu.entity.User">
            <constructor-arg name="username" value="chendikai"></constructor-arg>
        </bean>
    </beans>
    ```

- 测试

    ```java
    package com.hbnu.entity;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:11
     */
    public class IOCTest {
    
        @Test
        public void userTest() {
            // 1、加载spring核心配置文件
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
            // 2、获取bean对象
            User user = (User) applicationContext.getBean("user");
    
            user.add();
        }
    }
    ```

##### 2、通过set方法注入属性

- 创建User类

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:03
     */
    public class User {
        private String username;
    
        public void setUsername(String username) {
            this.username = username;
        }
    
        public void add() {
            System.out.println("add......" + username);
        }
    }
    ```

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <!--<bean id="user" class="com.hbnu.entity.User"/>-->
    
        <!-- 通过静态工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory" factory-method="getUser"></bean>-->
    
        <!-- 通过实例工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory"></bean>
        <bean id="user" factory-bean="factory" factory-method="getUser"></bean>-->
    
        <!-- 属性注入 -->
        <!-- 通过有参构造函数注入属性 -->
        <!--
        <bean id="user" class="com.hbnu.entity.User">
            &lt;!&ndash;
            name属性：类中的属性名
            value属性：注入的值
            &ndash;&gt;
            <constructor-arg name="username" value="chendikai"></constructor-arg>
        </bean>
        -->
        <!-- 通过set方法注入属性 -->
        <bean id="user" class="com.hbnu.entity.User">
            <property name="username" value="zhangsanfeng"></property>
        </bean>
    </beans>
    ```

- 测试

    ```java
    package com.hbnu.entity;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:11
     */
    public class IOCTest {
    
        @Test
        public void userTest() {
            // 1、加载spring核心配置文件
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
            // 2、获取bean对象
            User user = (User) applicationContext.getBean("user");
    
            user.add();
        }
    }
    ```

##### 3、注入对象属性

- 创建UserDao类

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 9:31
     */
    public class UserDao {
        public void printUserDao() {
            System.out.println("UserDao......");
        }
    }
    ```

- 创建UserService类

    ```java
    package com.hbnu.entity;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 9:33
     */
    public class UserService {
        private UserDao userDao;
        
        public void setUserDao(UserDao userDao) {
            this.userDao = userDao;
        }
        
        public void printUserService() {
            System.out.println("UserService....");
            userDao.printUserDao();
        }
    }
    ```

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <!--<bean id="user" class="com.hbnu.entity.User"/>-->
    
        <!-- 通过静态工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory" factory-method="getUser"></bean>-->
    
        <!-- 通过实例工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory"></bean>
        <bean id="user" factory-bean="factory" factory-method="getUser"></bean>-->
    
        <!-- 属性注入 -->
        <!-- 通过有参构造函数注入属性 -->
        <!--
        <bean id="user" class="com.hbnu.entity.User">
            &lt;!&ndash;
            name属性：类中的属性名
            value属性：注入的值
            &ndash;&gt;
            <constructor-arg name="username" value="chendikai"></constructor-arg>
        </bean>
        -->
        <!-- 通过set方法注入属性 -->
        <!--<bean id="user" class="com.hbnu.entity.User">
            <property name="username" value="zhangsanfeng"></property>
        </bean>-->
    
        <bean id="user" class="com.hbnu.entity.UserDao"></bean>
    
        <bean id="userService" class="com.hbnu.entity.UserService">
            <property name="userDao" ref="user"></property>
        </bean>
    </beans>
    ```

- 测试

    ```java
    package com.hbnu.entity;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:11
     */
    public class IOCTest {
    
        @Test
        public void userTest() {
            // 1、加载spring核心配置文件
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
            // 2、获取bean对象
            UserService userService = (UserService) applicationContext.getBean("userService");
    
            userService.printUserService();
        }
    }
    ```

##### 4、注入复杂数据类型

​		数组、集合（list、map）、Properties

- 创建DataType类

    ```java
    package com.hbnu.entity;
    
    import java.util.List;
    import java.util.Map;
    import java.util.Properties;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 10:12
     */
    public class DataType {
        private String[] arr;
        private List<String> list;
        private Map<String, String> map;
        private Properties properties;
    
        public String[] getArr() {
            return arr;
        }
    
        public void setArr(String[] arr) {
            this.arr = arr;
        }
    
        public List<String> getList() {
            return list;
        }
    
        public void setList(List<String> list) {
            this.list = list;
        }
    
        public Map<String, String> getMap() {
            return map;
        }
    
        public void setMap(Map<String, String> map) {
            this.map = map;
        }
    
        public Properties getProperties() {
            return properties;
        }
    
        public void setProperties(Properties properties) {
            this.properties = properties;
        }
        
        public void test() {
            System.out.println("arr:" + arr);
            System.out.println("list:" + list);
            System.out.println("map:" + map);
            System.out.println("properties:" + properties);
        }
    }
    ```

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!-- 配置bean
        id属性：必须唯一
        class属性：需要交给spring管理的类的全路径
        -->
        <!--<bean id="user" class="com.hbnu.entity.User"/>-->
    
        <!-- 通过静态工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory" factory-method="getUser"></bean>-->
    
        <!-- 通过实例工厂管理Bean对象 -->
        <!--<bean id="factory" class="com.hbnu.entity.UserFactory"></bean>
        <bean id="user" factory-bean="factory" factory-method="getUser"></bean>-->
    
        <!-- 属性注入 -->
        <!-- 通过有参构造函数注入属性 -->
        <!--
        <bean id="user" class="com.hbnu.entity.User">
            &lt;!&ndash;
            name属性：类中的属性名
            value属性：注入的值
            &ndash;&gt;
            <constructor-arg name="username" value="chendikai"></constructor-arg>
        </bean>
        -->
        <!-- 通过set方法注入属性 -->
        <!--<bean id="user" class="com.hbnu.entity.User">
            <property name="username" value="zhangsanfeng"></property>
        </bean>-->
    
        <!--<bean id="user" class="com.hbnu.entity.UserDao"></bean>
    
        <bean id="userService" class="com.hbnu.entity.UserService">
            <property name="userDao" ref="user"></property>
        </bean>-->
    
        <bean id="dataType" class="com.hbnu.entity.DataType">
            <!-- 1、数组类型 -->
            <property name="arr">
                <list>
                    <value>铠</value>
                    <value>妲己</value>
                    <value>小乔</value>
                </list>
            </property>
    
            <!-- 2、list集合类型 -->
            <property name="list">
                <list>
                    <value>张三丰</value>
                    <value>张翠山</value>
                    <value>张无忌</value>
                </list>
            </property>
    
            <!-- 3、map集合类型 -->
            <property name="map">
                <map>
                    <entry key="name" value="陈迪凯"></entry>
                    <entry key="gender" value="男"></entry>
                    <entry key="address" value="湖北黄石"></entry>
                </map>
            </property>
            
            <!-- 4、Properties类型 -->
            <property name="properties">
                <props>
                    <prop key="driverClass">com.mysql.cj.jdbc.Driver</prop>
                    <prop key="url">jdbc:mysql:///hbnu</prop>
                    <prop key="username">root</prop>
                    <prop key="password">chendikai</prop>
                </props>
            </property>
        </bean>
    </beans>
    ```

- 测试

    ```java
    package com.hbnu.entity;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-01 10:11
     */
    public class IOCTest {
    
        @Test
        public void userTest() {
            // 1、加载spring核心配置文件
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    
            // 2、获取bean对象
            DataType dataType = (DataType) applicationContext.getBean("dataType");
    
            dataType.test();
        }
    }
    ```

#### 八、Spring中注解开发

##### 1、注解开发案例

- 项目结构

    导入aop的jar包

    ![image-20210308103934299](C:\Users\chend\AppData\Roaming\Typora\typora-user-images\image-20210308103934299.png)

- 配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/aop
            http://www.springframework.org/schema/beans/spring-aop.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">
    
        <!-- 开启注解扫描 -->
        <context:component-scan base-package="com.hbnu.annotation"></context:component-scan>
    </beans>
    ```

- 创建User类

    ```java
    package com.hbnu.annotation;
    
    import org.springframework.stereotype.Component;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 10:45
     */
    @Component(value = "user")
    public class User {
        public void add() {
            System.out.println("annotation....add...");
        }
    }
    ```

- 测试

    ```java
    package com.hbnu.annotation;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 10:51
     */
    public class AnnotationTest {
    
        @Test
        public void annoTest() {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation.xml");
    
            User user = (User) applicationContext.getBean("user");
    
            user.add();
        }
    }
    ```

    ​	在Spring中创建对象的注解有四个：@Component、@Controller(WEB层)、@Repository（数据层）、@Service（业务层）

##### 2、注解注入类类型

- 创建UserDao

    ```java
    package com.hbnu.annotation;
    
    import org.springframework.stereotype.Component;
    
    import javax.xml.crypto.KeySelector;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 11:05
     */
    @Component(value = "userDao")
    public class UserDao {
        public void add() {
            System.out.println("userdao....add...");
        }
    }
    ```

- 创建UserService

    ```java
    package com.hbnu.annotation;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 11:06
     */
    @Component(value = "userService")
    public class UserService {
    
        // @Autowired
        @Resource(name = "userDao")
        private UserDao userDao;
    
        public void printUserService() {
            System.out.println("UserService......");
            userDao.add();
        }
    }
    ```

- 配置文件

    ```java
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/aop
            http://www.springframework.org/schema/beans/spring-aop.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">
    
        <!-- 开启注解扫描 -->
        <context:component-scan base-package="com.hbnu.annotation"></context:component-scan>
    </beans>
    ```

- 测试

    ```java
    package com.hbnu.annotation;
    
    import org.junit.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    /**
     * @author 陈迪凯
     * @date 2021-03-08 10:51
     */
    public class AnnotationTest {
    
        @Test
        public void annoTest() {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation.xml");
    
            UserService userService = (UserService) applicationContext.getBean("userService");
    
            userService.printUserService();
        }
    }
    ```

