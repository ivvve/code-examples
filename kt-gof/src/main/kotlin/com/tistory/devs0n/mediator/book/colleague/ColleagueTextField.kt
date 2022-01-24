package com.tistory.devs0n.mediator.book.colleague

import com.tistory.devs0n.mediator.book.mediator.Mediator
import java.awt.Color
import java.awt.TextField
import java.awt.event.TextEvent
import java.awt.event.TextListener

class ColleagueTextField(
    text: String,
    columns: Int,
) : TextField(text, columns), TextListener, Colleague {
    private lateinit var mediator: Mediator

    // 상태가 변경되었음을 Mediator에게 통지
    override fun textValueChanged(e: TextEvent) {
        this.mediator.colleagueChanged()
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun changeColleagueEnabled(enabled: Boolean) {
        this.isEnabled = enabled
        this.background = when (enabled) {
            true -> Color.WHITE
            false -> Color.lightGray
        }
    }
}
