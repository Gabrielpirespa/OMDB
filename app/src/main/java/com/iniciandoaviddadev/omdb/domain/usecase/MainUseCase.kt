package com.iniciandoaviddadev.omdb.domain.usecase

import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.data.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainUseCase(
    private val mainRepository: MainRepository
) {

    fun movieFilter(search: String): Flow<MovieList?>? {
        return if (search.length >= 3){
            mainRepository.movieCatcher(search)
        } else {
            null
        }
    }
}
