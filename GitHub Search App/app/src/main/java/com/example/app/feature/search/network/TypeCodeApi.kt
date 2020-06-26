package com.example.app.feature.search.network

/*
import android.util.Log
import com.example.app.App
import com.example.app.common.ErrorManager
import com.example.app.common.Result
import com.example.app.common.Success
import com.example.app.feature.search.datamodel.SubmitPostInfo
import com.example.app.feature.search.datamodel.SubmitPostResponse
import com.google.gson.JsonObject
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.content.TextContent
import io.ktor.http.ContentType
*/

/**
 * Created by malho on 15,June,2020
 */

/*
class TypeCodeApi {

    private val TAG = this::javaClass.name
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    suspend fun submitPost(submitPostInfo: SubmitPostInfo): Result<SubmitPostResponse> {
        val url = "$BASE_URL/posts"
        val client = NetworkManager.client()
        val jsonBody = App.mInstance.gson.toJson(submitPostInfo)

        return try {
            val json = client.post<String> {
                url(url)
                body = TextContent(jsonBody, contentType = ContentType.Application.Json)
            }
            client.close()
            val response = App.mInstance.gson.fromJson(json, SubmitPostResponse::class.java)
            Log.d(TAG, response.toString())
            Success(response)
        } catch (exception: Exception) {
            ErrorManager.getFailure(exception)
        }
    }
}*/
