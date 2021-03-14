package com.example.app.feature.search.datamodel

import com.squareup.moshi.Json

/**
 * Created by Rajat Malhotra on 14-March-2021
 */

data class ErrorElement(
    @field:Json(name = "message") val message: String?,
    @field:Json(name = "resource") val resource: String?,
    @field:Json(name = "field") val field: String?,
    @field:Json(name = "code") val code: String?
)