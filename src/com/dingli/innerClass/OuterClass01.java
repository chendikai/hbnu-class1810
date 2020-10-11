package com.dingli.innerClass;

public class OuterClass01 {

    int id = 10;
    public String method2() {
        return "外部类方法";
    }

    public void method3() {
    }

    public void method() {
        class Inner {
            int id = 200;
            String name = "1810";
            public void method1() {

                System.out.println(id);
                System.out.println(OuterClass01.this.id);

                System.out.println(method2());
                System.out.println(OuterClass01.this.method2());
            }
            public String method2() {
                return "局部内部类方法";
            }
        }
        Inner inner = new Inner();
        inner.method1();
    }

}
