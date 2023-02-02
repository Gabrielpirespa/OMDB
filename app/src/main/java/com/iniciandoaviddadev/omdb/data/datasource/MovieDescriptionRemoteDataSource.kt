package com.iniciandoaviddadev.omdb.data.datasource

import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.data.api.PlotService
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.flow

class MovieDescriptionRemoteDataSource (
    private val plotService: PlotService
    ) {
    fun plotCatcher (imdb: String): Flow<MoviePlot?> {
        return flow {
            emit (plotService.callPlot(imdb))
        }
    }
}