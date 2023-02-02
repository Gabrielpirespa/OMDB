package com.iniciandoaviddadev.omdb.data.repository

import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.data.datasource.MainRemoteDataSource
import kotlinx.coroutines.flow.Flow


class MainRepository(private val mainRemoteDataSource: MainRemoteDataSource) {

    fun movieCatcher (search: String): Flow<MovieList?> {
        return mainRemoteDataSource.movieCatcher(search)
    }
}