package com.example.app.common

import com.example.app.App
import com.example.app.common.datamodel.Error
import io.ktor.client.features.ClientRequestException
import io.ktor.client.statement.readText

object ErrorManager {
    suspend fun <T> getFailure(exception: Exception): Failure<T> {
        return try {
            val responseJson = (exception as ClientRequestException).response.readText()
            val error = App.mInstance.gson.fromJson(responseJson, Error::class.java)
            Failure(error?.errors?.get(0)?.message)

        } catch (e: Exception) {
            Failure(exception.toString())
        }
    }
}