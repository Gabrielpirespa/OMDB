package com.iniciandoaviddadev.omdb.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iniciandoaviddadev.omdb.MovieList
import com.iniciandoaviddadev.omdb.domain.usecase.MainUseCase
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(private val mainUseCase: MainUseCase) : ViewModel() {
    val movie = MutableLiveData(MovieList())
    val loading = MutableLiveData(false)
    val vision = MutableLiveData(false)

    fun moviePasser(search: String) {
        viewModelScope.launch {
            mainUseCase.movieFilter(search)
                ?.onStart {
                    loading.value = true
                    vision.value = false
                }
                ?.onCompletion {
                    loading.value = false
                }
                ?.collect {
                    movie.value = it
                    vision.value = true
                }
        }
    }

}