package com.tistory.devs0n;

import static com.tistory.devs0n.ThreadUtils.logThreadInfo;
import static com.tistory.devs0n.ThreadUtils.sleep;

public class SynchroizedClass {
    public synchronized void sync() {
        System.out.println("SYNC BEFORE");
        logThreadInfo();
        sleep(4_000);
        logThreadInfo();
        System.out.println("SYNC AFTER");
    }

    public synchronized void sync1() {
        System.out.println("SYNC1 BEFORE");
        logThreadInfo();
        sleep(4_000);
        logThreadInfo();
        System.out.println("SYNC1 AFTER");
    }

    public synchronized void sync2() {
        System.out.println("SYNC2 BEFORE");
        logThreadInfo();
        sleep(4_000);
        logThreadInfo();
        System.out.println("SYNC2 AFTER");
    }

    public synchronized void syncPing() {
        System.out.println("SYNC PING BEFORE");
        logThreadInfo();
        sleep(4_000);
        this.syncPong();
        logThreadInfo();
        System.out.println("SYNC PING AFTER");
    }

    public synchronized void syncPong() {
        System.out.println("SYNC PONG BEFORE");
        logThreadInfo();
        sleep(4_000);
        this.syncPing();
        logThreadInfo();
        System.out.println("SYNC PONG AFTER");
    }
}
