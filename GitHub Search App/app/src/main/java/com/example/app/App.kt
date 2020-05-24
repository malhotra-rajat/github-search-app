package com.example.app

import android.app.Application
import com.google.gson.Gson

class App : Application() {

    val gson = Gson()
    companion object {
        lateinit var mInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }
}