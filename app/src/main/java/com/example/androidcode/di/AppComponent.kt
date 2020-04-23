package com.example.androidcode.di

import com.example.androidcode.FactsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidInjectionModule::class, ContextModule::class,
        NetworkModule::class, ActivityModule::class,
        RepositoryModule::class, ApiModule::class, ViewModelModule::class]
)
@Singleton
interface AppComponent {

    fun inject(app: FactsApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationBind(app: FactsApplication): Builder

        fun build(): AppComponent
    }
}