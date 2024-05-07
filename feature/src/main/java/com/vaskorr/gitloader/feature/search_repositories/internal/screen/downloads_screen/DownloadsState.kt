package com.vaskorr.gitloader.feature.search_repositories.internal.screen.downloads_screen

import com.vaskorr.gitloader.domain.model.GitRepository

internal data class DownloadsState(
    val repositoryList: List<GitRepository> = emptyList()
)
