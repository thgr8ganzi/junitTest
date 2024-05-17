package com.example.junittest.abstractTest;

abstract class Player {
    abstract void play(int pos);
    abstract void stop();
}
class AudioPlayer extends Player {
    @Override
    void play(int pos) {
        System.out.println("play = " + pos);
    }
    @Override
    void stop() {
        System.out.println("stop");
    }
}
class VideoPlayer extends Player {
    @Override
    void play(int pos) {
        System.out.println("play = " + pos);
    }
    @Override
    void stop() {
        System.out.println("stop");
    }
}
public class AbstractTest {
    public static void main(String[] args) {
        Player p = new Player() {
            @Override
            void play(int pos) {
                System.out.println("play = " + pos);
            }

            @Override
            void stop() {
                System.out.println("stop");
            }
        };
        p.play(300);
    }
}
