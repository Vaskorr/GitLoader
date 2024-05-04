package com.vaskorr.gitloader.data.api

import com.vaskorr.gitloader.data.internal.web.RemoteRepositoryImpl
import com.vaskorr.gitloader.data.internal.web.network.GitApi
import com.vaskorr.gitloader.domain.usecase.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [DataModuleInterface::class])
class DataModule {

    @Provides
    fun getHttpClient(): OkHttpClient{
        return OkHttpClient()
    }
}

@Module
internal interface DataModuleInterface{
    fun getGitApi(): GitApi
    @Binds
    fun provideRemoteRepository(impl: RemoteRepositoryImpl): RemoteRepository
}