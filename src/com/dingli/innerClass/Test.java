package com.dingli.innerClass;

public class Test {
    public static void main(String[] args) {
//        OuterClass outerClass = new OuterClass();
//        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
//        innerClass.innerMethod();

//        OuterClass01 outerClass01 = new OuterClass01();
//        outerClass01.method();

        new Test().callInnerClass(new InterfaceTest() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        });

    }

    public void callInnerClass(InterfaceTest interfaceTest) {
        interfaceTest.run();
    }
}
