package com.tistory.devs0n.scalar

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Tag(name = "User API")
@RestController
@RequestMapping("/api/users")
class UserController {
    private val users = mutableListOf(
        User(name = "Kim", country = "Korea", city = "Seoul"),
        User(name = "James", country = "USA", city = "New York"),
        User(name = "Chris", country = "Korea", city = "Incheon"),
    )

    @Operation(description = "사용자 조회")
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE]) // `produces` 설정을 해야 응답 예제가 나옴
    fun getUsers(
        @RequestParam(required = false) country: String?,
        @RequestParam(required = false) name: String?,
    ): List<User> {
        var response: List<User> = this.users

        if (country != null) {
            response = response.filter { it.country == country }
        }

        if (name != null) {
            response = response.filter { it.name == name }
        }

        return response
    }

    @Operation(description = "사용자 추가")
    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addUser(@RequestBody request: User): User {
        this.users.add(request)
        return request
    }
}

@Schema(description = "사용자 정보")
data class User(
    @Schema(description = "이름", example = "Lee")
    val name: String,
    @Schema(description = "국가", example = "Korea")
    val country: String,
    @Schema(description = "도시", example = "Seoul")
    val city: String,
)
