package com.example.api;

import com.example.config.AsyncConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
class AsyncService {
    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Async(AsyncConfiguration.ASYNC_TASK_EXECUTOR_BEAN)
    public void runAsync(String a, String b) {
        log.info("Async service is called - a={} b={}", a, b);
    }
}
