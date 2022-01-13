package com.tistory.devs0n.builder.resume

import java.time.LocalDate

data class Resume(
    var name: String? = null,
    var position: String? = null,
    var jobExperiences: MutableList<JobExperience> = mutableListOf(),
) {
    fun jobExperiences(provider: () -> JobExperience) {
        this.jobExperiences.add(provider.invoke())
    }
}

data class JobExperience(
    var company: String = "",
    var startedAt: LocalDate? = null,
    var endedAt: LocalDate? = null,
)

fun resume(init: Resume.() -> Unit): Resume {
    val resume = Resume()
    resume.init()
    return resume
}
