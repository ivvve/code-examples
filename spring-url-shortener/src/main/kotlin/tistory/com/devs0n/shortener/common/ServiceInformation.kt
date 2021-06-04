package tistory.com.devs0n.shortener.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ServiceInformation(
    @Value("\${service.host}") val host: String
)
