package com.vaskorr.gitloader.feature.search_repositories.internal.screen.downloads_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaskorr.gitloader.domain.model.GitRepository
import com.vaskorr.gitloader.domain.usecase.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class DownloadsViewModel(
    val localRepository: LocalRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(DownloadsState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val repositories = localRepository.getDownloadedRepositories()
                _uiState.update {
                    DownloadsState(repositories)
                }
            }
        }
    }

    fun onDelete(gitRepository: GitRepository) {
        Log.d("DELETE!", gitRepository.toString())
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                localRepository.deleteRepository(repository = gitRepository)
                val repositories = localRepository.getDownloadedRepositories()
                _uiState.update {
                    DownloadsState(repositories)
                }
            }
        }
    }

}