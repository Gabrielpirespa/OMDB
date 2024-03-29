package com.iniciandoaviddadev.omdb.domain.usecase

import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.data.repository.MainRepository

class MainUseCase(
    private val mainRepository: MainRepository
) {

    suspend fun movieFilter(search: String): MovieList? {
        return if (search.length >= 3){
            mainRepository.movieCatcher(search)
        } else {
            null
        }
    }
}
