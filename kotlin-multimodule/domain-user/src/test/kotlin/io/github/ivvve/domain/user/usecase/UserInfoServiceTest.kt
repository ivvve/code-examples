package io.github.ivvve.domain.user.usecase

import io.github.ivvve.domain.user.domain.InMemoryUserRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("UserInfoService")
class UserInfoServiceTest {
    val userRepository = InMemoryUserRepository()
    val userInfoService = UserInfoService(userRepository)

    @Test
    fun registerUser() {
        // given
        val loginId = "loginid"
        val password = "password"
        val email = "email@gmail.com"
        val displayName = "displayname"

        // when
        val newUser = userInfoService.registerUser(loginId, password, email, displayName)

        // then
        val registeredUser = userRepository.findById(newUser.getId())
        assertThat(newUser).isEqualTo(registeredUser!!)
    }

    @Test
    fun changeUserInfo() {
        // given
        val newUser = userInfoService.registerUser("loginId", "password", "email@gmail.com", "displayname")

        // when
        val newEmail = "newemail@gmail.com"
        val newDisplayName = "newdiaplayname"

        val changedUser = userInfoService.changeUserInfo(newUser.getRawId(), newEmail, newDisplayName)

        // then
        assertThat(changedUser.getEmail()).isEqualTo(newEmail)
        assertThat(changedUser.getDisplayName()).isEqualTo(newDisplayName)
    }
}