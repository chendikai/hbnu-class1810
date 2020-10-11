package com.dingli.common;

public class Test {
    public static void main(String[] args) {
        Object houYi1 = new HouYi("后羿", 30);
        Object houYi2 = new HouYi("后羿", 20);
        Object daji = new DaJi();

        System.out.println(houYi1.equals(houYi2));

        String str = "  fjowangpi wuafppiw uafhpapaf hwfpweh  ";
        String str1 = "  fjowangpi wuaFPPiwua fhpapa fhwfPWEH  ";
        System.out.println(str.length());
        System.out.println(str.indexOf("f"));
        System.out.println(str.lastIndexOf("f"));
        System.out.println(str.substring(6,25));
        System.out.println(str.trim());
        System.out.println(str.equals(str1)); // false
        System.out.println(str.equalsIgnoreCase(str1)); // true
        String[] s = str.split(" ");
        for (int i =  0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println(str.endsWith(" ")); // true
        String s1 = "abc";
        String s2 = s1 + "1810";

        StringBuffer stringBuffer = new StringBuffer("abc");
        System.out.println(stringBuffer.toString());
        stringBuffer.append("1810");
        System.out.println(stringBuffer.toString());
    }
}
