package com.vaskorr.domain.usecase

import com.vaskorr.domain.model.GitUser
import com.vaskorr.domain.model.NetworkResponse

interface RemoteRepository {
    fun getUserRepositories(username: String) : NetworkResponse<GitUser>
}