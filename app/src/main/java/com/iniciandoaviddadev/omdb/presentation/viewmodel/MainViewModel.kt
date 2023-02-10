package com.iniciandoaviddadev.omdb.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.domain.usecase.MainUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val mainUseCase: MainUseCase) : ViewModel() {
    val movie = MutableLiveData(MovieList())
    val loading = MutableLiveData(false)
    val vision = MutableLiveData(false)

    fun moviePasser(search: String) {
        viewModelScope.launch {
            loading.value = true
            vision.value = false
            movie.value = mainUseCase.movieFilter(search)
            loading.value = false
            vision.value = true
        }
    }
}