package com.example.junittest.aop;

public interface Calc {
    long factorial(long num); // JoinPoint
    long factPlus(long num1, long num2); // JoinPoint
    long minus(long num1, long num2); // JoinPoint
}
