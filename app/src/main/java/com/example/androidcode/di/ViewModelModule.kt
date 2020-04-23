package com.example.androidcode.di

import androidx.lifecycle.ViewModel
import com.example.androidcode.home.presentation.MainViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel
}