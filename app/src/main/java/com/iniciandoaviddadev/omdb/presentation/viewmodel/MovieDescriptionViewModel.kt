package com.iniciandoaviddadev.omdb.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.domain.usecase.MovieDescriptionUseCase
import kotlinx.coroutines.launch

class MovieDescriptionViewModel(private val useCase: MovieDescriptionUseCase) : ViewModel() {
    val plot = MutableLiveData(MoviePlot())
    val loading = MutableLiveData(false)
    val vision = MutableLiveData(false)

    fun plotPasser(imdb: String) {
        viewModelScope.launch {
            loading.value = true
            vision.value = false
            loading.value = false
            plot.value = useCase.plotFilter(imdb)
            vision.value = true
        }
    }
}