package com.tistory.devs0n.mediator.book.colleague

import com.tistory.devs0n.mediator.book.mediator.Mediator
import java.awt.Checkbox
import java.awt.CheckboxGroup
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class ColleagueCheckbox(
    caption: String,
    group: CheckboxGroup,
    state: Boolean,
) : Checkbox(caption, group, state), ItemListener, Colleague {
    private lateinit var mediator: Mediator

    // 상태가 변경되었음을 Mediator에게 통지
    override fun itemStateChanged(e: ItemEvent) {
        this.mediator.colleagueChanged()
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun changeColleagueEnabled(enabled: Boolean) {
        this.isEnabled = enabled
    }
}
