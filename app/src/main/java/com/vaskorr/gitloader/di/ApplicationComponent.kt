package com.vaskorr.gitloader.di

import android.content.Context
import com.vaskorr.data.api.DataModule
import com.vaskorr.gitloader.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

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