package com.tistory.devs0n.abstractfactory.lecture.factory

import com.tistory.devs0n.abstractfactory.lecture.ship.Anchor
import com.tistory.devs0n.abstractfactory.lecture.ship.Wheel
import com.tistory.devs0n.abstractfactory.lecture.ship.WhiteAnchorPro
import com.tistory.devs0n.abstractfactory.lecture.ship.WhiteWheelPro

class WhiteShipProPartsFactory : ShipPartsFactory {
    override fun createAnchor(): Anchor = WhiteAnchorPro()

    override fun createWheel(): Wheel = WhiteWheelPro()
}
