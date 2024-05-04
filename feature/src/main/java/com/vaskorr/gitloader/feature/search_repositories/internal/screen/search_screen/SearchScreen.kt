package com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vaskorr.gitloader.feature.search_repositories.internal.component.field.SearchTextField
import com.vaskorr.gitloader.feature.search_repositories.internal.component.list.RepositoryList

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchTextField(
            searchText = uiState.searchField,
            onSearchTextChanged = {
                viewModel.onSearchTextChanged(it)
            }
        )
        if (uiState.repositories.isNotEmpty()) {
            RepositoryList(repositoryList = uiState.repositories, onWebOpen = {}, onDownload = {})
        }
    }
}