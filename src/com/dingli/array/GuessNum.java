package com.dingli.array;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        Random random = new Random();

        int number  = random.nextInt(100) + 1;

        while (true) {
            Scanner scanner = new Scanner(System.in);

            int guessNumber = 0;
            try {
                guessNumber = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("您脾气太暴躁，不适合玩游戏，玩俄罗斯方块去吧！！！");
                break;
            }

            if (guessNumber > number) {
                System.out.println("您猜的数字偏大");
            } else if (guessNumber < number) {
                System.out.println("您猜的数字偏小");
            } else {
                System.out.println("恭喜您猜对了！！！");
                break;
            }
        }
    }
}
