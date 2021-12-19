package com.tistory.devs0n.abstractfactory

import com.tistory.devs0n.abstractfactory.lecture.factory.WhiteShipFactory
import com.tistory.devs0n.abstractfactory.lecture.factory.WhiteShipProPartsFactory

fun main() {
    val shipFactory = WhiteShipFactory(
//        WhiteShipFactory()
        WhiteShipProPartsFactory()
    )
    shipFactory.createShip()
}
