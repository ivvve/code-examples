package com.tistory.devs0n.dto.web

import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@RestController
class SealedClassController {
    @PostMapping("/sealed/customer")
    fun customerUserRequest(
        @Validated @Valid @RequestBody request: UserSignUpRequest.CustomerUser,
        result: BindingResult
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

    @PostMapping("/sealed/seller")
    fun sellerUserRequest(
        @Validated @Valid @RequestBody request: UserSignUpRequest.SellerUser,
        result: BindingResult
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

sealed class UserSignUpRequest(
    @field:NotBlank
    open val name: String,
    @field:Email
    open val email: String,
    @field:Size(min = 8, max = 100)
    open val password: String,
) {
    data class CustomerUser(
        override val email: String,
        override val name: String,
        override val password: String,

        @field:NotBlank
        val address: String,
    ) : UserSignUpRequest(
        name = name,
        email = email,
        password = password,
    )

    data class SellerUser(
        override val email: String,
        override val name: String,
        override val password: String,

        @field:NotBlank
        val companyName: String, // 회사명

        @field:Pattern(regexp = """^\d{3}-\d{2}-\d{4}$""")
        val businessRegistrationNumber: String, // 사업자 등록 번호
    ) : UserSignUpRequest(
        name = name,
        email = email,
        password = password,
    )
}
