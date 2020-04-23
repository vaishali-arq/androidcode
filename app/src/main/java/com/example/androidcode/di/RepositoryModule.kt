package com.example.androidcode.di

import com.example.androidcode.home.domain.FactsRepository
import com.example.androidcode.home.domain.FactsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindFactsRepository(factsRepository: FactsRepositoryImpl): FactsRepository
}