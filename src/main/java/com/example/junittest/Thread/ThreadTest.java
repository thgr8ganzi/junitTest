package com.example.junittest.Thread;

public class ThreadTest {
    static long startTime = 0;
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        Thread myThread2 = new Thread(new MyThread2());
        myThread1.start();
        myThread2.start();
        startTime = System.currentTimeMillis();

//        main 쓰레드가 myThread1, myThread2가 종료될때까지 대기
        myThread1.join();
        myThread2.join();

        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}
