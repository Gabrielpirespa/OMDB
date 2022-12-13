package com.iniciandoaviddadev.omdb.di

import com.iniciandoaviddadev.omdb.data.api.MovieService
import com.iniciandoaviddadev.omdb.data.datasource.MainRemoteDataSource
import com.iniciandoaviddadev.omdb.data.repository.MainRepository
import com.iniciandoaviddadev.omdb.domain.usecase.MainUseCase
import com.iniciandoaviddadev.omdb.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainModule = module {

    factory {
        MainRemoteDataSource(get<Retrofit>().create(MovieService::class.java))
    }

    viewModel {
        MainViewModel(
            MainUseCase(
                MainRepository(get())
                )
            )
    }
}

/*private fun getMovieService (retrofit: Retrofit) = retrofit.create(MovieService::class.java)*/
