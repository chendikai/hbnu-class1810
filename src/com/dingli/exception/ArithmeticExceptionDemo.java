package com.dingli.exception;

import java.time.Year;

public class ArithmeticExceptionDemo {
    public static void main(String[] args)  {
            divide(4,2);

    }
    public static void divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("不能被0整除");
        }
        int result = x / y;

    }
}
