package com.iniciandoaviddadev.omdb.di

import com.iniciandoaviddadev.omdb.network.MovieInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(MovieInterceptor())
            .build()
    }

    single{
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}