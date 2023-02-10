package com.iniciandoaviddadev.omdb.domain.usecase

import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.data.repository.MovieDescriptionRepository

class MovieDescriptionUseCase(private val movieDescriptionRepository: MovieDescriptionRepository) {
    suspend fun plotFilter (imdb: String): MoviePlot? {
        return movieDescriptionRepository.plotCatcher(imdb)
    }
}