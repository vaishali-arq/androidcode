package com.example.androidcode.di

import com.example.androidcode.home.domain.FactsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideFactsApiService(retrofit: Retrofit): FactsApiService =
        retrofit.create(FactsApiService::class.java)
}