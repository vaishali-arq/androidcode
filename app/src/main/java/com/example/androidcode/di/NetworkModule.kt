package com.example.androidcode.di

import com.example.androidcode.config.APIConstant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit
            .Builder()
            .baseUrl(APIConstant.apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}