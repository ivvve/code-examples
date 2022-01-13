package com.tistory.devs0n;

import java.time.Instant;

public class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void logThreadInfo() {
        System.out.printf(
                "[%s] Thread: %s\n",
                Instant.now(),
                Thread.currentThread().getName()
        );
    }
}
