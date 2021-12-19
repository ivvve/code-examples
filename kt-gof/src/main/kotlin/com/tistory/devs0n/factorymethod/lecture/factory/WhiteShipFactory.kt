package com.tistory.devs0n.factorymethod.lecture.factory

import com.tistory.devs0n.factorymethod.lecture.ship.Ship
import com.tistory.devs0n.factorymethod.lecture.ship.WhiteShip

class WhiteShipFactory : ShipFactory {
    override fun createShip(): Ship = WhiteShip()
}
