package com.example.app.feature.search.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.common.Resource
import com.example.app.feature.search.datamodel.GithubRepos
import com.example.app.feature.search.repositories.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(private val githubRepository: GithubRepository) :
    ViewModel() {

    private val _reposResource = MutableLiveData<Resource<GithubRepos>>()

    val reposResource: LiveData<Resource<GithubRepos>>
        get() = _reposResource

    var dispatcher = Dispatchers.IO

    fun searchRepos(org: String) {
        viewModelScope.launch(dispatcher) {
            _reposResource.postValue(Resource.loading(null))
            _reposResource.postValue(githubRepository.searchRepos(org))
        }
    }
}