package com.iniciandoaviddadev.omdb.domain.usecase

import com.iniciandoaviddadev.omdb.data.repository.MovieDescriptionRepository
import com.iniciandoaviddadev.omdb.MoviePlot

class MovieDescriptionUseCase(private val movieDescriptionRepository: MovieDescriptionRepository) {
    suspend fun plotFilter (imdb: String, plotSize: String): MoviePlot? {
        return movieDescriptionRepository.plotCatcher(imdb, plotSize)
    }
}