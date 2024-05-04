package com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen

import androidx.compose.runtime.Immutable
import com.vaskorr.domain.model.GitRepository

@Immutable
data class SearchState(
    val searchField: String = "",
    val repositories: List<GitRepository> = emptyList()
)
