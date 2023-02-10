package com.iniciandoaviddadev.omdb.data.repository

import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.data.datasource.MovieDescriptionRemoteDataSource

class MovieDescriptionRepository(
    private val movieDescriptionRemoteDataSource: MovieDescriptionRemoteDataSource
    ) {
    suspend fun plotCatcher(imdb: String): MoviePlot? {
        return movieDescriptionRemoteDataSource.plotCatcher(imdb)
    }
}