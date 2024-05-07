package com.vaskorr.gitloader.feature.search_repositories.internal.screen.downloads_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vaskorr.gitloader.feature.search_repositories.internal.component.list.RepositoryList
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun DownloadsScreen(
    viewModel: DownloadsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    RepositoryList(
        repositoryList = uiState.repositoryList,
        onDelete = {viewModel.onDelete(it)},
        isLocal = true
    )
}