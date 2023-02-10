package com.iniciandoaviddadev.omdb.data.repository

import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.data.datasource.MainRemoteDataSource


class MainRepository(private val mainRemoteDataSource: MainRemoteDataSource) {

    suspend fun movieCatcher (search: String): MovieList? {
        return mainRemoteDataSource.movieCatcher(search)
    }
}