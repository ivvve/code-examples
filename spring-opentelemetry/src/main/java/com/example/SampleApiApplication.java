package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableScheduling
@SpringBootApplication
public class SampleApiApplication {
    private static final Logger log = LoggerFactory.getLogger(SampleApiApplication.class);

    private final TaskExecutor taskExecutor;

    public SampleApiApplication(@Qualifier("ASYNC_TASK_EXECUTOR_BEAN") TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApiApplication.class, args);
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void cron() {
        var currentTime = LocalDateTime.now();
        log.info("This is cron job! {}", currentTime);

        this.taskExecutor.execute(() -> {
            log.info("This is async job! {}", currentTime);
        });
    }
}
