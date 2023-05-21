package com.example.viewpager

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        sharedPreferences  = getSharedPreferences(Constants.PREFERENCES_ACCEPT,Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    companion object{
        lateinit var sharedPreferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
    }
}