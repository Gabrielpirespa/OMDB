package com.iniciandoaviddadev.omdb.data.api

import com.iniciandoaviddadev.omdb.MoviePlot
import retrofit2.http.GET
import retrofit2.http.Query

interface PlotService {
    @GET("/")
    suspend fun callPlot (@Query ("i") imdb: String, @Query("plot") plotSize: String): MoviePlot?
}
