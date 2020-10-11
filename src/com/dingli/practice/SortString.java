package com.dingli.practice;

import java.util.Scanner;

public class SortString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        int[] num = new int[s.length];

        try {
            for (int i = 0; i < s.length; i++) {
                num[i] = Integer.parseInt(s[i]);
            }

            // 排序前的数据
            for (int i = 0; i < num.length; i++) {
                if (i == num.length -1 ) {
                    System.out.println(num[i]);
                    break;
                }
                System.out.print(num[i] + " ");
            }

            // 冒泡排序
            for (int i = 0; i < num.length - 1; i++) {
                for (int j = 0; j < num.length - 1 - i; j++) {
                    if (num[j] > num[j+1]) {
                        int temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                    }
                }
            }

            // 将排序后的数据添加到stringBuilder
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < num.length; i++) {
                if (i == num.length - 1) {
                    stringBuilder.append(num[i]);
                    break;
                }
                stringBuilder.append(num[i] + " ");
            }

            System.out.println(stringBuilder.toString());

        } catch (Exception e) {
            System.out.println("你输入的数据中有非数字字符串！！！！");
        }
    }
}
