package com.example.app.feature.search.datamodel

import com.squareup.moshi.Json

data class GithubRepos(
    @field:Json(name = "total_count") val totalCount: Long?,
    @field:Json(name = "incomplete_results") val incompleteResults: Boolean?,
    @field:Json(name = "items") val items: List<Item>?
)



