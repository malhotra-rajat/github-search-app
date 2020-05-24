package com.example.app.feature.search.repositories

import com.example.app.common.Success
import com.example.app.feature.search.datamodel.GithubRepos
import com.example.app.feature.search.domain.GithubReposModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GithubRepositoryTest {

    @Mock
    private lateinit var githubRepository: GithubRepository

    @Test
    fun `should not return null on Success response from searchRepos`() {
        runBlocking {
            `when`(githubRepository.searchRepos("github")).thenReturn(
                Success(GithubReposModel(GithubRepos()))
            )
            val result = githubRepository.searchRepos("github")
            assertNotNull(result)
        }
    }
}