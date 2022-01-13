package com.tistory.devs0n;

public class NotSame {
    public static void main(String[] args) {
        new Thread(() -> {
            new SynchroizedClass().sync();
        }).start();

        new Thread(() -> {
            new SynchroizedClass().sync();
        }).start();
    }
}
