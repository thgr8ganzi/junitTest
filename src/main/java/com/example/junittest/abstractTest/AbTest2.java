package com.example.junittest.abstractTest;

public class AbTest2 extends AbTest{
    protected AbTest2(int anInt) {
        super(anInt);
    }

    @Override
    void play(int pos) {
        System.out.println("AbTest extend AbTest2= " + pos + " anInt = " + super.getAnInt());
    }
    @Override
    void stop() {
        System.out.println("stop");
    }
}
