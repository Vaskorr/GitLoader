package com.vaskorr.data.api

import com.vaskorr.data.internal.web.RemoteRepositoryImpl
import com.vaskorr.data.internal.GitApi
import com.vaskorr.domain.usecase.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [DataModule.DataModuleInterface::class])
class DataModule {

    @Provides
    fun getHttpClient(): OkHttpClient{
        return OkHttpClient()
    }

    @Module
    internal interface DataModuleInterface{
        fun getGitApi(): GitApi
        @Binds
        fun provideRemoteRepository(impl: RemoteRepositoryImpl): RemoteRepository
    }
}