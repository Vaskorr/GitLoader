package com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaskorr.domain.usecase.RemoteRepository
import com.vaskorr.gitloader.GitLoaderApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel : ViewModel() {
    @Inject
    lateinit var repository: RemoteRepository
    private val _uiState = MutableStateFlow(SearchState())
    val uiState = _uiState.asStateFlow()

    fun onSearchTextChanged(searchText: String){
        _uiState.update {
            uiState.value.copy(searchField = searchText)
        }
    }

    init {
        GitLoaderApplication().component.inject(this)
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