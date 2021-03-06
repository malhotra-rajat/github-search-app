package com.example.app.feature.search.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.feature.search.domain.GithubReposModel
import com.example.app.common.Result
import com.example.app.feature.search.repositories.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel @ViewModelInject constructor(private val githubRepository: GithubRepository): ViewModel() {

    var reposResult = MutableLiveData<Result<GithubReposModel>>()
    var dispatcher = Dispatchers.IO

    fun searchRepos(org: String) {
        viewModelScope.launch (dispatcher) {
            val reposResultModel = githubRepository.searchRepos(org)
            reposResult.postValue(reposResultModel)
        }
    }
}