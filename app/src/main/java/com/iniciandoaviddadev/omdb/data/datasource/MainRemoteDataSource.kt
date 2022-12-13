package com.iniciandoaviddadev.omdb.data.datasource

import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.data.api.MovieService

class MainRemoteDataSource (
    private val movieService: MovieService
        ) {
    suspend fun movieCatcher(search: String): MovieList? {
        return movieService.callMovie(search)
    }
}