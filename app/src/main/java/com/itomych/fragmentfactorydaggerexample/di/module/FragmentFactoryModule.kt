package com.itomych.fragmentfactorydaggerexample.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.itomych.fragmentfactorydaggerexample.MyFragmentFactory
import com.itomych.fragmentfactorydaggerexample.ui.Fragment1
import com.itomych.fragmentfactorydaggerexample.ui.Fragment2
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class FragmentFactoryModule {

    @Binds
    abstract fun bindFragmentFactory(factory : MyFragmentFactory) : FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(Fragment1::class)
    abstract fun bindFragment1(fragment : Fragment1) : Fragment

    @Binds
    @IntoMap
    @FragmentKey(Fragment2::class)
    abstract fun bindFragment2(fragment : Fragment2) : Fragment
}

@MapKey
annotation class FragmentKey(val clazz : KClass<out Fragment>)