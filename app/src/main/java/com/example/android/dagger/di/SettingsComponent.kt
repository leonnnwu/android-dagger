package com.example.android.dagger.di

import com.example.android.dagger.settings.SettingsActivity
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SettingsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsComponent
    }

    fun inject(activity: SettingsActivity)
}