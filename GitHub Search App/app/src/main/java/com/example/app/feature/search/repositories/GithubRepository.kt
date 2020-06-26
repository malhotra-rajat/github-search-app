package com.example.app.feature.search.repositories

import com.example.app.common.Failure
import com.example.app.common.Result
import com.example.app.common.Success
import com.example.app.feature.search.domain.GithubReposModel
import com.example.app.feature.search.network.GithubApi
import javax.inject.Inject

class GithubRepository @Inject constructor(private val githubApi: GithubApi) {
    suspend fun searchRepos(org: String): Result<GithubReposModel> {
        val gitHubApiResponse = githubApi.searchRepos(org)

        return if (gitHubApiResponse is Success) {
            Success(
                GithubReposModel(
                    gitHubApiResponse.data
                )
            )
        } else {
            val err = gitHubApiResponse as Failure
            return Failure(err.errorString)
        }
    }
}