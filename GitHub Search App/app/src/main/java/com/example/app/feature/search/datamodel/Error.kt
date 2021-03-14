package com.example.app.feature.search.datamodel
import com.squareup.moshi.Json

data class Error(
    @field:Json(name = "message") val message: String?,
    @field:Json(name = "errors") val errors: List<ErrorElement>?,
    @field:Json(name = "documentation_url") val documentationURL: String?
)