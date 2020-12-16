package kcb

import kcb.client.KCBClient

fun main() {
    val kcbClient = KCBClient()

    val fullText = kcbClient.directInquiry("1234567890")

}