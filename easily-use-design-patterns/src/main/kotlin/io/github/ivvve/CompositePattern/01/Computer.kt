package io.github.ivvve.CompositePattern.`01`

class Computer(val monitor: Monitor) {
    val name = "구성"
}

class Monitor {
    val name = "모니터"
}

fun main() {
    val computer = Computer(Monitor())

    println(computer.name)
    println(computer.monitor.name)
}