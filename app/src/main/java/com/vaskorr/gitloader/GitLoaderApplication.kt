package com.vaskorr.gitloader

import android.app.Application
import com.vaskorr.gitloader.data.api.dataModule
import com.vaskorr.gitloader.feature.search_repositories.api.di.searchRepositoriesModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.fileProperties

class GitLoaderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(applicationContext)
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            addModules()
            fileProperties()
        }
    }

    private fun KoinApplication.addModules() {
        val dataModules = module { includes(dataModule) }
        val featureModules = module { includes(searchRepositoriesModule) }
        modules(dataModules, featureModules)
    }

}