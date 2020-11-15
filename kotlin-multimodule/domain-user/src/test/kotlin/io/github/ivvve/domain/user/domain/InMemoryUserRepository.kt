package io.github.ivvve.domain.user.domain

class InMemoryUserRepository: UserRepository {
    private val users = mutableMapOf<UserID, User>()

    override fun save(user: User): User {
        this.users[user.getId()] = user
        return user
    }

    override fun findById(userId: UserID): User? {
        return this.users[userId]
    }
}