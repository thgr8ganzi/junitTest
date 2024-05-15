package com.example.junittest.aop;

import org.springframework.stereotype.Component;

@Component
public class BasicCalc implements Calc{
    @Override
    public long factorial(long num) {
        long result = 1;
        for (long i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public long factPlus(long num1, long num2) {
        return num1 + num2;
    }

    @Override
    public long minus(long num1, long num2) {
        return num1 - num2;
    }
}
