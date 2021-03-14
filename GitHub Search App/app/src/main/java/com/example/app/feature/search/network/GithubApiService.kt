package com.example.app.feature.search.network

import com.example.app.feature.search.datamodel.GithubRepos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiService {
    @GET("/search/repositories")
    suspend fun searchRepos(
        @Query("q") org: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("per_page") perPage: String
    ): Response<GithubRepos>
}