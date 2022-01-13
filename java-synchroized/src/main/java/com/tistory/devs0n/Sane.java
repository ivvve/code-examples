package com.tistory.devs0n;

public class Sane {
    public static void main(String[] args) {
        final SynchroizedClass synchroizedClass = new SynchroizedClass();

        new Thread(synchroizedClass::sync).start();
        new Thread(synchroizedClass::sync).start();
    }
}
