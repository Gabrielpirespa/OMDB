package com.iniciandoaviddadev.omdb.data.api

import com.iniciandoaviddadev.omdb.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/")
    suspend fun callMovie (@Query ("s") search: String) : MovieList?
}