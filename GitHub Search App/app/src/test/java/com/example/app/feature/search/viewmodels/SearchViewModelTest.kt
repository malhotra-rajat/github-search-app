package com.example.app.feature.search.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.app.common.Failure
import com.example.app.common.Success
import com.example.app.feature.search.CoroutinesTestRule
import com.example.app.feature.search.datamodel.GithubRepos
import com.example.app.feature.search.domain.GithubReposModel
import com.example.app.feature.search.repositories.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class SearchViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private lateinit var searchViewModel: SearchViewModel

    @Mock
    private lateinit var githubRepository: GithubRepository

    @Before
    fun setUp() {
        searchViewModel = SearchViewModel(githubRepository)
        searchViewModel.dispatcher = Dispatchers.Main
    }

    @Test
    fun `reposResult is Success on searchRepos Success`() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            Assert.assertNull(searchViewModel.reposResult.value)
            `when`(githubRepository.searchRepos("github")).thenReturn(Success(GithubReposModel(GithubRepos())))
            searchViewModel.searchRepos("github")
            Assert.assertTrue(searchViewModel.reposResult.value is Success)
        }
    }

    @Test
    fun `reposResult is Failure on searchRepos Failure`() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            Assert.assertNull(searchViewModel.reposResult.value)
            `when`(githubRepository.searchRepos("github")).thenReturn(Failure())
            searchViewModel.searchRepos("github")
            Assert.assertTrue(searchViewModel.reposResult.value is Failure)
        }
    }
}