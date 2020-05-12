package com.itomych.fragmentfactorydaggerexample.di

import com.itomych.fragmentfactorydaggerexample.MainApplication
import com.itomych.fragmentfactorydaggerexample.di.module.ActivityModule
import com.itomych.fragmentfactorydaggerexample.di.module.DependencyModule
import com.itomych.fragmentfactorydaggerexample.di.module.FragmentFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        FragmentFactoryModule::class,
        DependencyModule::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MainApplication): AppComponent
    }
}