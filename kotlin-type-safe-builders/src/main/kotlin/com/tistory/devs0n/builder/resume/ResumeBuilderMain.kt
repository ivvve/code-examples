package com.tistory.devs0n.builder.resume

fun main() {
    mutableListOf<Any>().apply {  }
    val resume = resume {
        name = "devson"
        position = "Back-end Developer"
        jobExperiences {
            JobExperience()
            JobExperience()
            JobExperience()
        }
    }
    println(resume)
}
