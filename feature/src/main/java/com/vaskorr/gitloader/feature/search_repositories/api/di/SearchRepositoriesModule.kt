package com.vaskorr.gitloader.feature.search_repositories.api.di

import com.vaskorr.gitloader.feature.search_repositories.internal.screen.downloads_screen.DownloadsViewModel
import com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val searchRepositoriesModule = module {
    viewModelOf(::SearchViewModel)
    viewModelOf(::DownloadsViewModel)
}