package io.github.ivvve.securityoauth

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class MyFilter : Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        request as HttpServletRequest

        if (request.requestURI == "/") {
            response.contentType = "application/json"
            response.writer.println("""{"message": "Hello World!"}""")
            return
        }

        chain.doFilter(request, response)
    }
}
