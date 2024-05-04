package com.vaskorr.gitloader.data.api

import com.vaskorr.gitloader.data.internal.web.RemoteRepositoryImpl
import com.vaskorr.gitloader.data.internal.web.network.GitApi
import com.vaskorr.gitloader.domain.usecase.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.binds
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    single { GitApi(apiKey = getProperty("GIT_API_TOKEN"), client = get())}
    factoryOf(::OkHttpClient)
    singleOf(::RemoteRepositoryImpl) {
        bind<RemoteRepository>()
    }
}