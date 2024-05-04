package com.vaskorr.gitloader.domain.usecase

import com.vaskorr.gitloader.domain.model.GitRepository

interface LocalRepository {
    fun getDownloadedRepositories(): List<GitRepository>
}