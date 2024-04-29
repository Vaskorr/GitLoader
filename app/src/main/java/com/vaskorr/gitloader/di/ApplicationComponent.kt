package com.vaskorr.gitloader.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {
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