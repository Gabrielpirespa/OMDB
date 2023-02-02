package com.iniciandoaviddadev.omdb.domain.usecase

import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.data.repository.MovieDescriptionRepository
import kotlinx.coroutines.flow.Flow

class MovieDescriptionUseCase(private val movieDescriptionRepository: MovieDescriptionRepository) {
    fun plotFilter (imdb: String): Flow<MoviePlot?> {
        return movieDescriptionRepository.plotCatcher(imdb)
    }
}