package com.itomych.fragmentfactorydaggerexample.di.module

import com.itomych.fragmentfactorydaggerexample.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}