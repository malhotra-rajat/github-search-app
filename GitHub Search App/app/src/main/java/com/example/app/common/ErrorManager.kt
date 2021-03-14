package com.example.app.common

import com.example.app.feature.search.datamodel.GithubRepos
import com.squareup.moshi.Moshi
import retrofit2.Response
import javax.inject.Inject

class ErrorManager @Inject constructor(private val moshi: Moshi) {
    private val GENERIC_ERROR = "Something went wrong"
    fun getError(response: Response<GithubRepos>): String {
        try {
            val responseJson = response.errorBody()?.string()
            responseJson?.let { it ->
                val jsonAdapter =
                    moshi.adapter(com.example.app.feature.search.datamodel.Error::class.java)
                jsonAdapter.fromJson(it)?.errors?.get(0)?.message?.let { errorString ->
                    return errorString
                }
            }
            return GENERIC_ERROR
        } catch (e: Exception) {
            return GENERIC_ERROR
        }
    }
}