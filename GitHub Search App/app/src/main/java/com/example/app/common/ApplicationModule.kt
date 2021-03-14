package com.example.app.common

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideHttpClient() = HttpClient()

    @Provides
    @Singleton
    fun provideGson() = Gson()
}