package com.example.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var mInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        
    }
}