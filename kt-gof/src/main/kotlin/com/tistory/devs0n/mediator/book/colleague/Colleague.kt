package com.tistory.devs0n.mediator.book.colleague

import com.tistory.devs0n.mediator.book.mediator.Mediator

interface Colleague {
    fun setMediator(mediator: Mediator)

    fun changeColleagueEnabled(enabled: Boolean)
}
