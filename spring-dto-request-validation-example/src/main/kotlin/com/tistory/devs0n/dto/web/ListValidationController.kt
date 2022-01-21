package com.tistory.devs0n.dto.web

import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@RestController
@RequestMapping("/list")
class ListValidationController {
    @PostMapping
    fun listRequest(
        @Validated @Valid @RequestBody request: ListRequest,
        result: BindingResult,
    ): Any {
        if (result.allErrors.isEmpty()) {
            return request
        }

        return result.allErrors.map {
            mapOf(
                "message" to it.toString(),
            )
        }
    }
}

data class ListRequest(
    @field:Size(min = 1)
    @field:Valid
    val ranges: List<Range>,
)

data class Range(
    @field:Min(1)
    @field:Max(6)
    val from: Int,

    @field:Min(1)
    @field:Max(6)
    val to: Int,
)
