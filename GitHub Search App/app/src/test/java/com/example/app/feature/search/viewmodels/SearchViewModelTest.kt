package com.example.app.feature.search.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Spy
    private lateinit var searchViewModel: SearchViewModel

    @Mock
    private lateinit var githubRepository: GithubRepository

    @Before
    fun setUp() {
        searchViewModel.githubRepository = githubRepository
        searchViewModel.dispatcher = Dispatchers.Main
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should update repos on searchRepos`() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            Assert.assertNull(searchViewModel.repos.value)
            `when`(githubRepository.searchRepos("github")).thenReturn(Success(GithubReposModel(GithubRepos())))
            searchViewModel.searchRepos("github")
            Assert.assertNotNull(searchViewModel.repos.value)
        }
    }
}