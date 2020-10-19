
package com.dingli.annotation;

@MyAnnotation(name = "jixin", anno = {"1810", "hbnu"})
public class AnnotationTest {
    private String name;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        test1();
    }

    @Deprecated
    public static void test1() {
        System.out.println("Depricated。。。。。。");
    }

    @MyAnnotation(name = "jixin", anno = {"1810", "hbnu"})
    public static void test2() {

    }

    @Override
    public String toString() {
        return "AnnotationTest{" +
                "name='" + name + '\'' +
                '}';
    }
}


