package com.dingli.innerClass;

public class OuterClass {
    private int id = 100;

    public String outerMethod() {
        return "外部类方法";
    }

    public String method() {
        return "外部类同名方法";
    }

    public class InnerClass {
        private int id = 200;
        String name = "1810";

        public void innerMethod() {
            System.out.println(id);
            System.out.println(OuterClass.this.id);

            System.out.println(method());
            System.out.println(OuterClass.this.method());
        }

        public String method() {
            return "内部类同名方法";
        }
    }
}
