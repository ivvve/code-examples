package com.tistory.devs0n.mediator.book.colleague

import com.tistory.devs0n.mediator.book.mediator.Mediator
import java.awt.Button

class ColleagueButton(
    label: String,
) : Button(label), Colleague {
    private lateinit var mediator: Mediator

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun changeColleagueEnabled(enabled: Boolean) {
        this.isEnabled = enabled
    }
}
