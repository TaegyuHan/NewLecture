package com.example.boot3.demo.java.exception;

public class Calc {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) throws NoMinusException, 매개변수가10000을넘는Exception {
        int result = a - b;

        if (10_000 < result) {
            throw new 매개변수가10000을넘는Exception();
        }

        if (result < 0) {
            throw new NoMinusException("음수는 입력할 수 없습니다.");
        }
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }
}