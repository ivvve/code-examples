package io.github.ivvve.security.config.security

import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse


class RequestLoggingFilter : Filter {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java.name)
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val authentication = SecurityContextHolder.getContext().authentication

        if (authentication != null) {
            LOGGER.info("User ${authentication.principal} is authenticated and has authorities: ${authentication.authorities}")
        }

        chain.doFilter(request, response)
    }
}