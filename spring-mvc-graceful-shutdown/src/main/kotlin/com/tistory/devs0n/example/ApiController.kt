package com.tistory.devs0n.example

import org.slf4j.LoggerFactory
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(
    private val asyncService: AsyncService,
    private val taskExecutor: TaskExecutor,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/sync")
    fun sync(): String {
        this.logger.info("Sync job is starting...")
        Thread.sleep(10_000)
        this.logger.info("Sync job has finished!")

        return "OK"
    }

    @GetMapping("/async")
    fun async(): String {
        if (this.taskExecutor is ThreadPoolTaskExecutor) {
            println("thread count in pool: ${this.taskExecutor.threadPoolExecutor.poolSize}")
            println("active thread count: ${this.taskExecutor.threadPoolExecutor.activeCount}")
        }
        this.asyncService.asyncJob()
        return "OK"
    }
}

@Service
class AsyncService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Async
    fun asyncJob() {
        this.logger.info("Async job is starting...")
        Thread.sleep(5_000)
        this.logger.info("Async job has finished!")
    }
}
