package com.tistory.devs0n.factorymethod.lecture.factory

import com.tistory.devs0n.factorymethod.lecture.ship.BlackShip
import com.tistory.devs0n.factorymethod.lecture.ship.Ship

class BlackShipFactory : ShipFactory {
    override fun createShip(): Ship = BlackShip()
}
