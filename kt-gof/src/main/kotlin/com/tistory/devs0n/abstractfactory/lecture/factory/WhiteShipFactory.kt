package com.tistory.devs0n.abstractfactory.lecture.factory

import com.tistory.devs0n.abstractfactory.lecture.ship.Ship

// Client
class WhiteShipFactory(
    private val shipPartsFactory: ShipPartsFactory,
) : ShipFactory {
    override fun createShip(): Ship {
        return Ship(
            this.shipPartsFactory.createAnchor(),
            this.shipPartsFactory.createWheel(),
        )
    }
}
