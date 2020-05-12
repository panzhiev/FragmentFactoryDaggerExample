package com.itomych.fragmentfactorydaggerexample.di.module

import com.itomych.fragmentfactorydaggerexample.dependency.Dependency1
import com.itomych.fragmentfactorydaggerexample.dependency.Dependency2
import dagger.Module
import dagger.Provides

@Module
class DependencyModule {

    @Provides
    fun bindDependency1() = Dependency1()

    @Provides
    fun bindDependency2() = Dependency2()
}