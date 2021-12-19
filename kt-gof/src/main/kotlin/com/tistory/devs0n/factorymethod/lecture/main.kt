package com.tistory.devs0n.factorymethod

import com.tistory.devs0n.factorymethod.lecture.factory.BlackShipFactory
import com.tistory.devs0n.factorymethod.lecture.factory.WhiteShipFactory
import java.util.*

fun main() {
    BlackShipFactory().orderShip("blackship", "black@gmail.com")
    WhiteShipFactory().orderShip("whiteship", "white@gmail.com")

    // sun.util.BuddhistCalendar
    println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")).javaClass)

    // java.util.JapaneseImperialCalendar
    println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")).javaClass)
}
