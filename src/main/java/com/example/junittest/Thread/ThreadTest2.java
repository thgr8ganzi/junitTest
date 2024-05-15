package com.example.junittest.Thread;

public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        Thread myThread2 = new Thread(new MyThread2());

        myThread2.setPriority(7);
        System.out.println("myThread1.getPriority() = " + myThread1.getPriority());
        System.out.println("myThread2.getPriority() = " + myThread2.getPriority());
        myThread1.start();
        myThread2.start();
    }
}
