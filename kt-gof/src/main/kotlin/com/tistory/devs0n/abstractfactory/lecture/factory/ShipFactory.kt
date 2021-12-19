package com.tistory.devs0n.abstractfactory.lecture.factory

import com.tistory.devs0n.abstractfactory.lecture.ship.Ship

interface ShipFactory {
    fun createShip(): Ship
}
