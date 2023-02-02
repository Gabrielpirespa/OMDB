package com.iniciandoaviddadev.omdb.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iniciandoaviddadev.omdb.MoviePlot
import com.iniciandoaviddadev.omdb.domain.usecase.MovieDescriptionUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MovieDescriptionViewModel(private val useCase: MovieDescriptionUseCase): ViewModel() {
    val plot = MutableLiveData(MoviePlot())
    val loading = MutableLiveData(false)
    val vision = MutableLiveData(false)

    fun plotPasser (imdb: String) {
        viewModelScope.launch {
            useCase.plotFilter(imdb)
                .onStart {
                    loading.value = true
                    vision.value = false
                }
                .onCompletion {
                    loading.value = false
                }
                .catch{
                    it.message
                }
                .collect{
                    plot.value = it
                    vision.value = true
                }
        }
    }
}