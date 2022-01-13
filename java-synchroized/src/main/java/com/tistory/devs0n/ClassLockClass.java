package com.tistory.devs0n;

import static com.tistory.devs0n.ThreadUtils.logThreadInfo;
import static com.tistory.devs0n.ThreadUtils.sleep;

public class ClassLockClass {
    public static void main(String[] args) {
        new Thread(ClassLockClass::sync1).start();
        new Thread(ClassLockClass::sync2).start();
    }

    public static synchronized void sync() {
        System.out.println("SYNC BEFORE");
        logThreadInfo();
        sleep(4_000);
        logThreadInfo();
        System.out.println("SYNC AFTER");
    }

    public static synchronized void sync1() {
        System.out.println("SYNC1 BEFORE");
        logThreadInfo();
        sleep(4_000);
        logThreadInfo();
        System.out.println("SYNC1 AFTER");
    }

    public static synchronized void sync2() {
        System.out.println("SYNC2 BEFORE");
        logThreadInfo();
        sleep(4_000);
        logThreadInfo();
        System.out.println("SYNC2 AFTER");
    }
}
