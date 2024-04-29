package com.vaskorr.domain.usecase

import com.vaskorr.domain.model.GitRepository

interface LocalRepository {
    fun getDownloadedRepositories(): List<GitRepository>
}