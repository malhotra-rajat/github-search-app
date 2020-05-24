package com.example.app.feature.search.network

import com.example.app.App
import com.example.app.common.ErrorManager
import com.example.app.common.NetworkManager
import com.example.app.common.Result
import com.example.app.common.Success
import com.example.app.feature.search.datamodel.GithubRepos
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class GithubApi {
    private val BASE_URL = "https://api.github.com"

    suspend fun searchRepos(org: String): Result<GithubRepos> {
        val url = "$BASE_URL/search/repositories"
        val client = NetworkManager.client()

        return try {
            val json = client.get<String> {
                parameter("q", "org:$org")
                parameter("sort", "stars")
                parameter("order", "desc")
                parameter("per_page", "3")
                url(url)
            }
            client.close()
            val repos = App.mInstance.gson.fromJson(json, GithubRepos::class.java)
            Success(repos)

        } catch (exception: Exception) {
            ErrorManager.getFailure(exception)
        }
    }
}