package io.github.ivvve.securityoauth.core.user.domain.authentication

class GithubUserAuthentication(
    method: AuthenticationMethod,
    val githubNodeId: String
) : UserAuthentication(method)