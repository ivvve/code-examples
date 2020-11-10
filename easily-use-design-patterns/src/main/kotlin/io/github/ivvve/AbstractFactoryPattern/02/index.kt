package io.github.ivvve.AbstractFactoryPattern.`02`

fun main() {
    val koreaFactory = KoreaFactory()

    val koreaTire = koreaFactory.createTire()
    koreaTire.makeAssemble()

    val koreaDoor = koreaFactory.createDoor()
    koreaDoor.makeAssemble()

    println("-------------------")

    val stateFactory = StateFactory()

    val stateTire = stateFactory.createTire()
    stateTire.makeAssemble()

    val stateDoor = stateFactory.createDoor()
    stateDoor.makeAssemble()
}