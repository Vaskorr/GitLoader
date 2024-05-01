package com.vaskorr.data.internal.web

import com.vaskorr.data.internal.GitApi
import com.vaskorr.domain.model.GitRepository
import com.vaskorr.domain.model.GitUser
import com.vaskorr.domain.model.NetworkResponse
import com.vaskorr.domain.model.NetworkResponseStatus
import com.vaskorr.domain.usecase.RemoteRepository
import java.net.URL
import javax.inject.Inject

internal class RemoteRepositoryImpl @Inject constructor(
    private val gitApi: GitApi
) : RemoteRepository {
    override fun getUserRepositories(username: String): NetworkResponse<GitUser> {
        val repList = gitApi.getUserRepositories(username)
        val gitUserName = repList[0].owner?.login
        val repositoryList = mutableListOf<GitRepository>()
        repList.forEach {
            repositoryList.add(GitRepository(
                it.name!!,
                it.owner?.login!!,
                URL(it.url),
                null
            ))
        }
        return NetworkResponse(NetworkResponseStatus.SUCCESS, GitUser(gitUserName!!, repositoryList))
    }
}