package com.example.app.feature.search.datamodel

import com.squareup.moshi.Json

/**
 * Created by Rajat Malhotra on 14-March-2021
 */
data class Item(
    @field:Json(name = "id") val id: Long?,
    @field:Json(name = "node_id") val nodeID: String?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "full_name") val fullName: String?,
    @field:Json(name = "private") val private: Boolean?,
    @field:Json(name = "owner") val owner: Owner?,
    @field:Json(name = "html_url") val htmlURL: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "fork") val fork: Boolean?,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "forks_url") val forksURL: String?,
    @field:Json(name = "keys_url") val keysURL: String?,
    @field:Json(name = "collaborators_url") val collaboratorsURL: String?,
    @field:Json(name = "teams_url") val teamsURL: String?,
    @field:Json(name = "hooks_url") val hooksURL: String?,
    @field:Json(name = "issue_events_url") val issueEventsURL: String?,
    @field:Json(name = "events_url") val eventsURL: String?,
    @field:Json(name = "assignees_url") val assigneesURL: String?,
    @field:Json(name = "branches_url") val branchesURL: String?,
    @field:Json(name = "tags_url") val tagsURL: String?,
    @field:Json(name = "blobs_url") val blobsURL: String?,
    @field:Json(name = "git_tags_url") val gitTagsURL: String?,
    @field:Json(name = "git_refs_url") val gitRefsURL: String?,
    @field:Json(name = "trees_url") val treesURL: String?,
    @field:Json(name = "statuses_url") val statusesURL: String?,
    @field:Json(name = "languages_url") val languagesURL: String?,
    @field:Json(name = "stargazers_url") val stargazersURL: String?,
    @field:Json(name = "contributors_url") val contributorsURL: String?,
    @field:Json(name = "subscribers_url") val subscribersURL: String?,
    @field:Json(name = "subscription_url") val subscriptionURL: String?,
    @field:Json(name = "commits_url") val commitsURL: String?,
    @field:Json(name = "git_commits_url") val gitCommitsURL: String?,
    @field:Json(name = "comments_url") val commentsURL: String?,
    @field:Json(name = "issue_comment_url") val issueCommentURL: String?,
    @field:Json(name = "contents_url") val contentsURL: String?,
    @field:Json(name = "compare_url") val compareURL: String?,
    @field:Json(name = "merges_url") val mergesURL: String?,
    @field:Json(name = "archive_url") val archiveURL: String?,
    @field:Json(name = "downloads_url") val downloadsURL: String?,
    @field:Json(name = "issues_url") val issuesURL: String?,
    @field:Json(name = "pulls_url") val pullsURL: String?,
    @field:Json(name = "milestones_url") val milestonesURL: String?,
    @field:Json(name = "notifications_url") val notificationsURL: String?,
    @field:Json(name = "labels_url") val labelsURL: String?,
    @field:Json(name = "releases_url") val releasesURL: String?,
    @field:Json(name = "deployments_url") val deploymentsURL: String?,
    @field:Json(name = "created_at") val createdAt: String?,
    @field:Json(name = "updated_at") val updatedAt: String?,
    @field:Json(name = "pushed_at") val pushedAt: String?,
    @field:Json(name = "git_url") val gitURL: String?,
    @field:Json(name = "ssh_url") val sshURL: String?,
    @field:Json(name = "clone_url") val cloneURL: String?,
    @field:Json(name = "svn_url") val svnURL: String?,
    @field:Json(name = "homepage") val homepage: String?,
    @field:Json(name = "size") val size: Long?,
    @field:Json(name = "stargazers_count") val stargazersCount: Long?,
    @field:Json(name = "watchers_count") val watchersCount: Long?,
    @field:Json(name = "language") val language: String?,
    @field:Json(name = "has_issues") val hasIssues: Boolean?,
    @field:Json(name = "has_projects") val hasProjects: Boolean?,
    @field:Json(name = "has_downloads") val hasDownloads: Boolean?,
    @field:Json(name = "has_wiki") val hasWiki: Boolean?,
    @field:Json(name = "has_pages") val hasPages: Boolean?,
    @field:Json(name = "forks_count") val forksCount: Long?,
    @field:Json(name = "mirror_url") val mirrorURL: Any?,
    @field:Json(name = "archived") val archived: Boolean?,
    @field:Json(name = "disabled") val disabled: Boolean?,
    @field:Json(name = "open_issues_count") val openIssuesCount: Long?,
    @field:Json(name = "license") val license: License?,
    @field:Json(name = "forks") val forks: Long?,
    @field:Json(name = "open_issues") val openIssues: Long?,
    @field:Json(name = "watchers") val watchers: Long?,
    @field:Json(name = "default_branch") val defaultBranch: String?,
    @field:Json(name = "score") val score: Long?
)