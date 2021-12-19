package com.tistory.devs0n.abstractfactory.lecture.factory

import com.tistory.devs0n.abstractfactory.lecture.ship.Anchor
import com.tistory.devs0n.abstractfactory.lecture.ship.Wheel
import com.tistory.devs0n.abstractfactory.lecture.ship.WhiteAnchor
import com.tistory.devs0n.abstractfactory.lecture.ship.WhiteWheel

class WhiteShipPartsFactory : ShipPartsFactory {
    override fun createAnchor(): Anchor = WhiteAnchor()

    override fun createWheel(): Wheel = WhiteWheel()
}
