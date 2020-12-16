package io.github.ivvve.CompositePattern.`02`

class Computer(
    val monitor: Monitor,
    val disk: Disk,
    val memory: Memory
) {
    val name = "구성"
}

class Monitor {
    val name = "모니터"
}


class Disk {
    val name = "디스크"
}

class Memory {
    val name = "메모리"
}

fun main() {
    val computer = Computer(
        Monitor(),
        Disk(),
        Memory()
    )

    println(computer.name)
    println(computer.monitor.name)
    println(computer.disk.name)
    println(computer.memory.name)
}