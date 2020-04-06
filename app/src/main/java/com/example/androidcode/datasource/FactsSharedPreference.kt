package com.example.androidcode.datasource

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder

object FactsSharedPreference {
    private val PREFERENCES_FILE_NAME = "facts_sharedpreference"
    lateinit var sharedPref: SharedPreferences

    fun init(application: Application) {
        sharedPref = application.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Store object into SharedPreferences
     * @param key Shared Preference key with which object was saved.
     * @param `object` Object to store in preference
     */
    fun <T> put(`object`: T, key: String) {
        //Convert object to JSON String.
        val jsonString = GsonBuilder().create().toJson(`object`)
        //Save that String in SharedPreferences
        sharedPref.edit().putString(key, jsonString).apply()
    }

    /**
     * Used to retrieve object from the SharedPreferences.
     *
     * @param key Shared Preference key with which object was saved.
     **/
    inline fun <reified T> get(key: String): T? {
        //We read JSON String which was saved.
        val value = sharedPref.getString(key, null)
        return GsonBuilder().create().fromJson(value, T::class.java)
    }
}