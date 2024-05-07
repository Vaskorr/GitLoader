package com.vaskorr.gitloader.domain.usecase

import com.vaskorr.gitloader.domain.model.GitRepository
import com.vaskorr.gitloader.domain.model.GitUser
import com.vaskorr.gitloader.domain.model.NetworkResponse

interface RemoteRepository {
    fun getUserRepositories(username: String): NetworkResponse<GitUser>
    fun downloadRepository(repository: GitRepository)
}