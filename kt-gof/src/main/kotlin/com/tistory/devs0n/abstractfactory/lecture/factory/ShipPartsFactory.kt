package com.tistory.devs0n.abstractfactory.lecture.factory

import com.tistory.devs0n.abstractfactory.lecture.ship.Anchor
import com.tistory.devs0n.abstractfactory.lecture.ship.Wheel

interface ShipPartsFactory {
    fun createAnchor(): Anchor

    fun createWheel(): Wheel
}
