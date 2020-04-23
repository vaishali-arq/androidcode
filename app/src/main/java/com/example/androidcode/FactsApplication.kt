package com.example.androidcode

import android.app.Application
import com.example.androidcode.datasource.FactsSharedPreference
import com.example.androidcode.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class FactsApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        FactsSharedPreference.init(this)

        DaggerAppComponent.builder().applicationBind(this).build().inject(this)
    }
}