package com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen

import androidx.compose.runtime.Immutable
import com.vaskorr.gitloader.domain.model.GitRepository

@Immutable
internal data class SearchState(
    val searchField: String = "",
    val repositories: List<GitRepository> = emptyList()
)
