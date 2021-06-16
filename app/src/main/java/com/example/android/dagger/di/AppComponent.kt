package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// Definition of a Dagger component
@Singleton
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {
    // Expose RegistrationComponent factory from the graph
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    // 2) Expose UserManager so that MainActivity and SettingsActivity
    // can access a particular instance of UserComponent
    fun userManager(): UserManager

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }
}