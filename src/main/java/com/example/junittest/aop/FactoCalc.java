package com.example.junittest.aop;

import org.springframework.stereotype.Component;

@Component
public class FactoCalc implements Calc {
    @Override
    public long factorial(long num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
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
