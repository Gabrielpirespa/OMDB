package com.iniciandoaviddadev.omdb


data class MovieList(
    val Search: List<MovieResponse>? = null
)

data class MovieResponse(
    val Title: String? = null,
    val Poster: String? = null,
    val imdbID: String? = null
)

data class MoviePlot(
    val Plot: String? = null
)