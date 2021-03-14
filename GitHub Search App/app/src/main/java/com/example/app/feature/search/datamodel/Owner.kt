package com.example.app.feature.search.datamodel

import com.squareup.moshi.Json

/**
 * Created by Rajat Malhotra on 14-March-2021
 */
data class Owner(
    @field:Json(name = "login") val login: String?,
    @field:Json(name = "id") val id: Long?,
    @field:Json(name = "node_id") val nodeID: String?,
    @field:Json(name = "avatar_url") val avatarURL: String?,
    @field:Json(name = "gravatar_id") val gravatarID: String?,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "html_url") val htmlURL: String?,
    @field:Json(name = "followers_url") val followersURL: String?,
    @field:Json(name = "following_url") val followingURL: String?,
    @field:Json(name = "gists_url") val gistsURL: String?,
    @field:Json(name = "starred_url") val starredURL: String?,
    @field:Json(name = "subscriptions_url") val subscriptionsURL: String?,
    @field:Json(name = "organizations_url") val organizationsURL: String?,
    @field:Json(name = "repos_url") val reposURL: String?,
    @field:Json(name = "events_url") val eventsURL: String?,
    @field:Json(name = "received_events_url") val receivedEventsURL: String?,
    @field:Json(name = "type") val type: String?,
    @field:Json(name = "site_admin") val siteAdmin: Boolean?
)