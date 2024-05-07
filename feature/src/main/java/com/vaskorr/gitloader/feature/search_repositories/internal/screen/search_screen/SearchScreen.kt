package com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import org.koin.androidx.compose.koinViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vaskorr.gitloader.core.R
import com.vaskorr.gitloader.feature.search_repositories.internal.component.field.SearchTextField
import com.vaskorr.gitloader.feature.search_repositories.internal.component.list.RepositoryList

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchTextField(
            searchText = uiState.searchField,
            onSearchTextChanged = {
                viewModel.onSearchTextChanged(it)
            },
            onSearch = {
                viewModel.onSearch()
            },
            onTextClear = {
                viewModel.onTextClear()
            }
        )
        if (uiState.repositories.isNotEmpty()) {
            RepositoryList(repositoryList = uiState.repositories, onWebOpen = {}, onDownload = {viewModel.onDownload(it)})
        }else{
            Text(
                text = stringResource(id = R.string.user_not_found),
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}