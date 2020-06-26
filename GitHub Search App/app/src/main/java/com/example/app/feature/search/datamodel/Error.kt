package com.example.app.feature.search.datamodel

import com.google.gson.annotations.SerializedName

data class Error(
    val message: String? = null,
    val errors: List<ErrorElement>? = null,

    @SerializedName("documentation_url")
    val documentationURL: String? = null
)

data class ErrorElement(
    val message: String? = null,
    val resource: String? = null,
    val field: String? = null,
    val code: String? = null
)
