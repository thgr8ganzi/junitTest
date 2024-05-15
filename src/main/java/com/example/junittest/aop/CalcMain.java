package com.example.junittest.aop;

public class CalcMain {
    public static void main(String[] args) {
        Calc basic = new BasicCalc();
        Calc facto = new FactoCalc();

        long basicStart = System.nanoTime();
        basic.factorial(100);
        long basicEnd = System.nanoTime();
        System.out.println("BasicCalc.factorial(100) : " + (basicEnd - basicStart) + "ms");

        long factoStart = System.nanoTime();
        facto.factorial(100);
        long factoEnd = System.nanoTime();
        System.out.println("FactoCalc.factorial(100) : " + (factoEnd - factoStart) + "ms");


    }
}
