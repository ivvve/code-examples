package com.tistory.devs0n.rw

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession

@Configuration
class HandlerConfig {
    @Bean
    fun handlerMapping(): HandlerMapping {
        return SimpleUrlHandlerMapping(
            mutableMapOf<String, Any>()
        )
    }
}

class HelloHandler : WebSocketHandler {
    override fun afterConnectionEstablished(session: WebSocketSession) {
        TODO("Not yet implemented")
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        TODO("Not yet implemented")
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        TODO("Not yet implemented")
    }

    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
        TODO("Not yet implemented")
    }

    override fun supportsPartialMessages(): Boolean {
        TODO("Not yet implemented")
    }
}
