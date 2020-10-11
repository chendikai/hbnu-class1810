package com.dingli.array;

import java.util.Scanner;

public class JosperCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入玩游戏人数：");
        int n = scanner.nextInt();

        System.out.println("开始报数人的编号：");
        int k = scanner.nextInt();

        System.out.println("数数间隔：");
        int m = scanner.nextInt();

        int[] persons = new int[n];
        int[] seq = new int[n];

        for (int i = 0; i < n; i++) {
            int index = k;
            for (int j = 0; j < m; index++) {
                if (persons[index % n] == 0) {
                    j++;
                }
            }
            persons[(index - 1) % n] = 1;
            seq[i] = (index - 1) % n;
            k = index % n;
        }

        System.out.println("游戏出局人编号：");
        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i] + " ");
        }
    }
}
