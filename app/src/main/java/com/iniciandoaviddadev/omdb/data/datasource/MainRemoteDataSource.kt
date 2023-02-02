package com.iniciandoaviddadev.omdb.data.datasource

import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.data.api.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRemoteDataSource (
    private val movieService: MovieService
        ) {
    fun movieCatcher(search: String): Flow<MovieList?> {
        return flow {
            emit(movieService.callMovie(search))
        }
    }
}