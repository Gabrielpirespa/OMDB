package com.iniciandoaviddadev.omdb.data.repository

import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.data.datasource.MovieDescriptionRemoteDataSource
import kotlinx.coroutines.flow.Flow

class MovieDescriptionRepository(
    private val movieDescriptionRemoteDataSource: MovieDescriptionRemoteDataSource
    ) {
    fun plotCatcher(imdb: String): Flow<MoviePlot?> {
        return movieDescriptionRemoteDataSource.plotCatcher(imdb)
    }
}