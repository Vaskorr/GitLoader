package com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaskorr.gitloader.domain.model.GitRepository
import com.vaskorr.gitloader.domain.usecase.LocalRepository
import com.vaskorr.gitloader.domain.usecase.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URI
import java.net.URL

class SearchViewModel (
    private val repository: RemoteRepository,
    private val localRepository: LocalRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SearchState())
    val uiState = _uiState.asStateFlow()

    fun onSearchTextChanged(searchText: String){
        _uiState.update {
            uiState.value.copy(searchField = searchText)
        }
    }

    fun onSearch(){
        viewModelScope.launch {
            val uiStateNew: SearchState
            withContext(Dispatchers.IO) {
                uiStateNew = SearchState(
                    searchField = uiState.value.searchField, repositories = repository.getUserRepositories(uiState.value.searchField).body.repositories
                )
            }
            _uiState.update {
                uiStateNew
            }
        }
    }

    fun onTextClear(){
        _uiState.update {
            uiState.value.copy(searchField = "")
        }
    }

    init {
        viewModelScope.launch {
            val uiStateNew: SearchState
            withContext(Dispatchers.IO) {
                uiStateNew = SearchState(
                    "Vaskorr", repository.getUserRepositories("Vaskorr").body.repositories
                )
            }
            _uiState.update {
                uiStateNew
            }
        }
    }

}