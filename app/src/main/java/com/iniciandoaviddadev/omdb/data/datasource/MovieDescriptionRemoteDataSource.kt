package com.iniciandoaviddadev.omdb.data.datasource

import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.data.api.PlotService

class MovieDescriptionRemoteDataSource(
    private val plotService: PlotService
) {
    suspend fun plotCatcher(imdb: String): MoviePlot? {
        return plotService.callPlot(imdb)
    }
}