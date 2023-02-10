package com.iniciandoaviddadev.omdb

import com.iniciandoaviddadev.omdb.data.api.MovieService
import com.iniciandoaviddadev.omdb.data.datasource.MainRemoteDataSource
import com.iniciandoaviddadev.omdb.data.repository.MainRepository
import com.iniciandoaviddadev.omdb.domain.usecase.MainUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SearchServiceTests {

    @Test
    fun `should call the API when receive a name`()= runTest {
        //Arrange
        val movieListApi = mockk<MovieService>()
        val mainRemoteDataSource = MainRemoteDataSource(movieListApi)
        val search = "Harry Potter"

        coEvery {
            movieListApi.callMovie(search)
        } returns (MovieList())

        //Action
        mainRemoteDataSource.movieCatcher(search)

        //Assert
        coVerify {
            movieListApi.callMovie(search)
        }
    }

    @Test
    fun `should not start search when the string has less than three letters`()= runTest{
        //Arrange
        val mainRepository = mockk<MainRepository>()
        val mainUseCase = MainUseCase(mainRepository)
        val searchInvalid = "Ha"

        coEvery {
            mainRepository.movieCatcher(searchInvalid)
        } returns (MovieList())

        //Action
        mainUseCase.movieFilter(searchInvalid)

        //Assert
        coVerify (inverse = true){
            mainRepository.movieCatcher(searchInvalid)
        }
    }

    @Test
    fun `should start search when the string has three or more letters`()= runTest{
        //Arrange
        val mainRepository = mockk<MainRepository>()
        val mainUseCase = MainUseCase(mainRepository)
        val searchValid = "Har"

        coEvery {
            mainRepository.movieCatcher(searchValid)
        } returns (MovieList())

        //Action
        mainUseCase.movieFilter(searchValid)

        //Assert
        coVerify {
            mainRepository.movieCatcher(searchValid)
        }
    }

}