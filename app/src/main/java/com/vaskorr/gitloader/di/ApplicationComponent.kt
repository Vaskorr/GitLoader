package com.vaskorr.gitloader.di

import android.content.Context
import com.vaskorr.gitloader.data.api.DataModule
import com.vaskorr.gitloader.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(searchViewModel: com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen.SearchViewModel)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            context: Context,
            @BindsInstance
            apiKey: String
        ): ApplicationComponent
    }
}