package com.example.androidcode.di

import android.content.Context
import com.example.androidcode.FactsApplication
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    fun provideContext(application: FactsApplication): Context = application.applicationContext
}