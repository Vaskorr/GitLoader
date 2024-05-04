package com.vaskorr.gitloader.data.internal.web

import com.vaskorr.gitloader.data.internal.web.network.GitApi
import com.vaskorr.gitloader.domain.model.GitRepository
import com.vaskorr.gitloader.domain.model.GitUser
import com.vaskorr.gitloader.domain.model.NetworkResponse
import com.vaskorr.gitloader.domain.model.NetworkResponseStatus
import com.vaskorr.gitloader.domain.usecase.RemoteRepository
import java.net.URL
import javax.inject.Inject

internal class RemoteRepositoryImpl @Inject constructor(
    private val gitApi: GitApi
) : RemoteRepository {
    override fun getUserRepositories(username: String): NetworkResponse<GitUser> {
        val repList = gitApi.getUserRepositories(username)
        if (repList.isNotEmpty()){
            val gitUserName = repList[0].owner?.login
            val repositoryList = mutableListOf<GitRepository>()
            repList.forEach {
                repositoryList.add(
                    GitRepository(
                        it.name!!,
                        it.owner?.login!!,
                        URL(it.url),
                        null
                    )
                )
            }
            return NetworkResponse(NetworkResponseStatus.SUCCESS, GitUser(gitUserName!!, repositoryList))
        }
        return NetworkResponse(NetworkResponseStatus.FAILED, GitUser("", emptyList()))
    }
}