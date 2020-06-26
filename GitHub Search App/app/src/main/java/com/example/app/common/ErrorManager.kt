package com.example.app.common

import com.example.app.feature.search.datamodel.Error
import com.google.gson.Gson
import io.ktor.client.features.ClientRequestException
import io.ktor.client.statement.readText
import javax.inject.Inject

class ErrorManager @Inject constructor(private val gson: Gson) {
    suspend fun <T> getFailure(exception: Exception): Failure<T> {
        return try {
            val responseJson = (exception as ClientRequestException).response.readText()
            val error = gson.fromJson(responseJson, Error::class.java)
            Failure(error?.errors?.get(0)?.message)

        } catch (e: Exception) {
            Failure(exception.toString())
        }
    }
}