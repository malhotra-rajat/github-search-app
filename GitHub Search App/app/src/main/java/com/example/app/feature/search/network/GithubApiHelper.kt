package com.example.app.feature.search.network

import com.example.app.feature.search.datamodel.GithubRepos
import retrofit2.Response

interface GithubApiHelper {
    suspend fun searchRepos(
        org: String,
        sort: String,
        order: String,
        perPage: String
    ): Response<GithubRepos>
}