package com.example.junittest.abstractTest;

public abstract class AbTest {
    private final int anInt;

    protected AbTest(int anInt) {
        this.anInt = anInt;
    }

    abstract void play(int pos);
    abstract void stop();

    protected int getAnInt() {
        return this.anInt;
    }
}
