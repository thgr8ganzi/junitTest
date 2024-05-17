package com.example.junittest.abstractTest;

public class AbMain {
    public static void main(String[] args) {
        AbTest2 abTest = new AbTest2(1);
        abTest.play(1);
        System.out.println(abTest.getAnInt());
        AbTest abTest2 = new AbTest2(2);
        abTest2.play(2);
        System.out.println(abTest2.getAnInt());
    }
}
