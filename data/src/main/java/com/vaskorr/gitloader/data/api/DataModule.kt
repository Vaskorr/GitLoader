package com.vaskorr.gitloader.data.api

import androidx.room.Room
import com.vaskorr.gitloader.data.internal.local.LocalRepositoryImpl
import com.vaskorr.gitloader.data.internal.local.db.AppDatabase
import com.vaskorr.gitloader.data.internal.web.RemoteRepositoryImpl
import com.vaskorr.gitloader.data.internal.web.network.GitApi
import com.vaskorr.gitloader.domain.usecase.LocalRepository
import com.vaskorr.gitloader.domain.usecase.RemoteRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::GitApi)
    factoryOf(::OkHttpClient)
    singleOf(::RemoteRepositoryImpl) {
        bind<RemoteRepository>()
    }
    singleOf(::LocalRepositoryImpl) {
        bind<LocalRepository>()
    }
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "repositories"
        ).build().repositoryDao()
    }
}