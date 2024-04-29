package com.vaskorr.gitloader

import android.app.Application
import com.vaskorr.gitloader.di.DaggerApplicationComponent

class GitLoaderApplication: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this, BuildConfig.GIT_API_TOKEN)
    }
}