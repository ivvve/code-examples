package com.tistory.devs0n.routing.common.utils

import java.time.Instant
import java.time.temporal.ChronoUnit

fun today(): Instant {
    return Instant.now().truncatedTo(ChronoUnit.HOURS)
}
