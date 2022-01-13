package com.tistory.devs0n.eventtx.core.application

import com.tistory.devs0n.eventtx.core.application.command.OrderCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCommandHandler {
    fun aa(command: OrderCommand.Order) {


    }
}
