package com.example.app.feature.search.network

import com.example.app.feature.search.datamodel.GithubRepos
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Rajat Malhotra on 14-March-2021
 */
class GithubApiHelperImpl @Inject constructor(
    private val githubApiService: GithubApiService
) : GithubApiHelper {
    override suspend fun searchRepos(
        org: String,
        sort: String,
        order: String,
        perPage: String
    ): Response<GithubRepos> =
        githubApiService.searchRepos(org, sort, order, perPage)
}