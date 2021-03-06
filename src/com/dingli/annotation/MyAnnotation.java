package com.dingli.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD}) // 规定当前注解的使用范围
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "jixin"; // 注解名，不是方法
    String[] anno();
}
