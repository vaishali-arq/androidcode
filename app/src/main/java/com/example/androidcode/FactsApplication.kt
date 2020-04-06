package com.example.androidcode

import android.app.Application
import com.example.androidcode.datasource.FactsSharedPreference

class FactsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FactsSharedPreference.init(this)
    }
}