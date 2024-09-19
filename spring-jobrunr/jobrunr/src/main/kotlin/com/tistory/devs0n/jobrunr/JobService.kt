package com.tistory.devs0n.jobrunr

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class JobService(
    private val ac: ApplicationContext
) {

    fun runJob() {
        val controller = this.ac.getBean(JobController::class.java)
        println(controller)

        if (Random.nextBoolean()) {
            throw IllegalArgumentException("FUCK KOREA!!!")
        }

        println("GGyu heung..!")
    }
}
