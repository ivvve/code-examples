package com.tistory.devs0n;

public class LockGet {
    public static void main(String[] args) {
        final SynchroizedClass synchroizedClass = new SynchroizedClass();
        new Thread(synchroizedClass::syncPing).start();
        new Thread(synchroizedClass::syncPong).start();
    }
}
