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
    val Title: String? = null,
    val Year: String? = null,
    val Released: String? = null,
    val Runtime: String? = null,
    val Genre: String? = null,
    val Director: String? = null,
    val Writer: String? = null,
    val Actors: String? = null,
    val Plot: String? = null,
    val Language: String? = null,
    val Poster: String? = null,
    val Metascore: String? = null,
    val imdbRating: String? = null,
    val Type: String? = null,
)