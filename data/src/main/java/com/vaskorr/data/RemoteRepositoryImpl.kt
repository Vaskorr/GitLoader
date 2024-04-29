package com.vaskorr.data

import com.vaskorr.domain.model.GitUser
import com.vaskorr.domain.model.NetworkResponse
import com.vaskorr.domain.usecase.RemoteRepository

class RemoteRepositoryImpl: RemoteRepository {
    override fun getUserRepositories(username: String): NetworkResponse<GitUser> {
        TODO("Not yet implemented")
    }
}