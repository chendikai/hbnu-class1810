package com.dingli.practice;

import java.util.Scanner;

public class Login {
    private static final int COUNT = 3;

    public static void main(String[] args) {
        User user = new User("jixin1810", "hbnu1810");// 真实用户信息

        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (count < COUNT) {
            System.out.println("请输入用户名：");
            String username = scanner.next();

            System.out.println("请输入密码：");
            String password = scanner.next();

            User user1 = new User(username, password);
            if (user1.equals(user)) {
                System.out.println("用户" + username + "成功登陆本系统！！！");
                break;
            }
            count++;

        }
        if (count == 3) {
            System.out.println("你登陆次数过多，请稍后再试！！！！");
        }

    }
}
