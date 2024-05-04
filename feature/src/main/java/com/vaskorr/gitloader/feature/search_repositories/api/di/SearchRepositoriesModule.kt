package com.vaskorr.gitloader.feature.search_repositories.api.di

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen.SearchViewModel

val searchRepositoriesModule = module{
    viewModelOf(::SearchViewModel)
}