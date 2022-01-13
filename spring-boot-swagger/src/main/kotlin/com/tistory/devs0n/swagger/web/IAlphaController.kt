package com.tistory.devs0n.swagger.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

interface IAlphaController {
    @Operation(summary = "Aplha 1 API")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "정상 응답")
    )
    fun aa() {

    }
}
