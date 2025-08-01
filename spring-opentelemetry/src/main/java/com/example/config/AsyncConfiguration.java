package com.example.config;

import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnThreading;
import org.springframework.boot.autoconfigure.thread.Threading;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfiguration {
    public static final String ASYNC_TASK_EXECUTOR_BEAN = "ASYNC_TASK_EXECUTOR_BEAN";

    @Bean(name = ASYNC_TASK_EXECUTOR_BEAN)
    @ConditionalOnThreading(Threading.VIRTUAL) // when `spring.threads.virtual.enabled` is `true`
    public TaskExecutor asyncTaskExecutor() {
        var taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setVirtualThreads(true);
        taskExecutor.setThreadNamePrefix("asyns-task-");
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationMillis(5_000L);
        // not to reuse virtual thread (it spawns new thread every time)
        taskExecutor.setKeepAliveSeconds(0);
        taskExecutor.setQueueCapacity(0);
        taskExecutor.setCorePoolSize(0);
        // to propagate MDC context
        taskExecutor.setTaskDecorator(runnable -> {
            var contextMap = MDC.getCopyOfContextMap();

            return () -> {
                if (contextMap != null) {
                    MDC.setContextMap(contextMap);
                }
                runnable.run();
            };
        });

        return taskExecutor;
    }
}
