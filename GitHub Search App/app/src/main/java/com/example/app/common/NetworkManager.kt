package com.example.app.common

import io.ktor.client.HttpClient

object NetworkManager {

    fun client(): HttpClient {
        return HttpClient()
    }
}
