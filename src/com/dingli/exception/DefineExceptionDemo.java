package com.dingli.exception;

public class DefineExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new DefineException("自定义异常");
        } catch (DefineException e) {
            e.printStackTrace();

        }
    }
}
