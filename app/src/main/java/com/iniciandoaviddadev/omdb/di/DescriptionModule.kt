package com.iniciandoaviddadev.omdb.di

import com.iniciandoaviddadev.omdb.data.api.PlotService
import com.iniciandoaviddadev.omdb.data.datasource.MovieDescriptionRemoteDataSource
import com.iniciandoaviddadev.omdb.data.repository.MovieDescriptionRepository
import com.iniciandoaviddadev.omdb.domain.usecase.MovieDescriptionUseCase
import com.iniciandoaviddadev.omdb.presentation.viewmodel.MovieDescriptionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val descriptionModule = module {

    factory {
        MovieDescriptionRemoteDataSource(get<Retrofit>().create(PlotService::class.java))
    }

    viewModel {
        MovieDescriptionViewModel(
            MovieDescriptionUseCase(
                MovieDescriptionRepository(get())
            )
        )
    }
}