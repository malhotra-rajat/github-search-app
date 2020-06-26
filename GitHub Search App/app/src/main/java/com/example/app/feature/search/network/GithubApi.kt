package com.example.app.feature.search.network

import com.example.app.common.ErrorManager
import com.example.app.common.Result
import com.example.app.common.Success
import com.example.app.feature.search.datamodel.GithubRepos
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import javax.inject.Inject

class GithubApi @Inject constructor(
    private val client: HttpClient,
    private val gson: Gson,
    private val errorManager: ErrorManager
) {
    private val BASE_URL = "https://api.github.com"

    suspend fun searchRepos(org: String): Result<GithubRepos> {
        val url = "$BASE_URL/search/repositories"

        return try {
            val json = client.get<String> {
                parameter("q", "org:$org")
                parameter("sort", "stars")
                parameter("order", "desc")
                parameter("per_page", "3")
                url(url)
            }
            val repos = gson.fromJson(json, GithubRepos::class.java)
            Success(repos)

        } catch (exception: Exception) {
            errorManager.getFailure(exception)
        }
    }
}