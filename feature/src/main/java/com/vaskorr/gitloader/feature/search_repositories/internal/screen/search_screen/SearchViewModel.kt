package com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaskorr.gitloader.domain.usecase.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel (
    private val repository: RemoteRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SearchState())
    val uiState = _uiState.asStateFlow()

    fun onSearchTextChanged(searchText: String){
        _uiState.update {
            uiState.value.copy(searchField = searchText)
        }
    }

    init {
        viewModelScope.launch {
            val uiState: SearchState
            withContext(Dispatchers.IO) {
                uiState = SearchState(
                    "Dimasik", repository.getUserRepositories("NewRonin").body.repositories
                )
            }
            _uiState.update {
                uiState.copy(searchField = "LOL")
            }
        }
    }

}