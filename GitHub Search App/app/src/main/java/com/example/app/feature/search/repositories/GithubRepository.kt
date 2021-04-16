package com.example.app.feature.search.repositories

import com.example.app.common.ErrorManager
import com.example.app.common.Resource
import com.example.app.feature.search.datamodel.GithubRepos
import com.example.app.feature.search.network.GithubApiService
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubApiService: GithubApiService,
    private val errorManager: ErrorManager
) {
    suspend fun searchRepos(org: String): Resource<GithubRepos> {
        return try {
            val response = githubApiService.searchRepos("org:$org", "stars", "desc", "3")

            if (response.isSuccessful && response.body() is GithubRepos) {
                Resource.success(response.body())
            } else {
                Resource.error(errorManager.getError(response), null)
            }
        } catch (e: Exception) {
            Resource.error(e.toString(), null)
        }
    }
}