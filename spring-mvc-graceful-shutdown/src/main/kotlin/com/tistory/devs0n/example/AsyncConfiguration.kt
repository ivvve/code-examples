package com.tistory.devs0n.example

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnThreading
import org.springframework.boot.autoconfigure.thread.Threading
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@EnableAsync
@Configuration
class AsyncConfiguration(
    @Value("\${spring.task.execution.thread-name-prefix}") private val taskThreadNamePrefix: String,
    @Value("\${spring.task.execution.shutdown.await-termination}") private val taskAwaitTermination: Boolean,
    @Value("\${spring.task.execution.shutdown.await-termination-period}") private val taskAwaitTerminationMillis: Long,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    @ConditionalOnThreading(Threading.VIRTUAL) // when `spring.threads.virtual.enabled` is `true`
    fun taskExecutor(): TaskExecutor {
        this.logger.info("Virtual thread is enabled. Register custom TaskExecutor")

        return ThreadPoolTaskExecutor().apply {
            this.setVirtualThreads(true)
            this.setThreadNamePrefix(taskThreadNamePrefix)
            this.setWaitForTasksToCompleteOnShutdown(taskAwaitTermination)
            this.setAwaitTerminationMillis(taskAwaitTerminationMillis)
            // not to reuse virtual thread (it spawns new thread every time)
            this.keepAliveSeconds = 0
            this.queueCapacity = 0
//            this.queueCapacity = 100
            this.corePoolSize = 0
//            this.maxPoolSize = 100
            // to propagate MDC context
            this.setTaskDecorator { runnable ->
                val contextMap = MDC.getCopyOfContextMap()

                Runnable {
                    if (contextMap != null) {
                        MDC.setContextMap(contextMap)
                    }
                    runnable.run()
                }
            }
        }
    }
}
