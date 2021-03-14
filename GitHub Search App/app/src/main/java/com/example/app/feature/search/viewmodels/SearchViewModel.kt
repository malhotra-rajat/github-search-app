package com.example.app.feature.search.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.feature.search.domain.GithubReposModel
import com.example.app.common.Result
import com.example.app.feature.search.repositories.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val githubRepository: GithubRepository): ViewModel() {

    private val _reposResult = MutableLiveData<Result<GithubReposModel>>()

    val reposResult: LiveData<Result<GithubReposModel>>
            get() = _reposResult

    var dispatcher = Dispatchers.IO

    fun searchRepos(org: String) {
        viewModelScope.launch (dispatcher) {
            val reposResultModel = githubRepository.searchRepos(org)
            _reposResult.postValue(reposResultModel)
        }
    }
}