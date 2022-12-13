package com.iniciandoaviddadev.omdb.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iniciandoaviddadev.omdb.domain.usecase.MovieDescriptionUseCase
import com.iniciandoaviddadev.omdb.MoviePlot
import kotlinx.coroutines.launch

class MovieDescriptionViewModel(private val useCase: MovieDescriptionUseCase): ViewModel() {
    val plot = MutableLiveData(MoviePlot())
    val loading = MutableLiveData(false)

    fun plotPasser (imdb: String, plotSize: String) {
        viewModelScope.launch {
            loading.value = true
            val plotResponse = useCase.plotFilter(imdb, plotSize)
            plot.value = plotResponse
            loading.value = false
        }
    }
}