package com.dingli.array;

import java.util.Scanner;

/**
 * 从键盘输入数据并存入数组中，然后将数组元素打印到控制台中
 */
public class Demo01 {
    public static void main(String[] args) {
//        从键盘输入数据
        Scanner scanner = new Scanner(System.in);

        // 1、将键盘输入数据存入数组
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        // 2、将键盘输入的数据打印到控制台
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
                break;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
