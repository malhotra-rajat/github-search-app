package com.example.app.feature.search.datamodel

import com.squareup.moshi.Json

/**
 * Created by Rajat Malhotra on 14-March-2021
 */
data class License(
    @field:Json(name = "key") val key: String?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "spdx_id") val spdxID: String?,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "node_id") val nodeID: String?
)