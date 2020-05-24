package com.example.app.feature.search.domain

import com.example.app.feature.search.datamodel.GithubRepos

class GithubReposModel (githubRepos: GithubRepos) {
    val repos = githubRepos.items
}