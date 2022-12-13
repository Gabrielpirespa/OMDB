package com.iniciandoaviddadev.omdb.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.iniciandoaviddadev.omdb.presentation.viewmodel.MovieDescriptionViewModel
import com.iniciandoaviddadev.omdb.databinding.MovieDescriptionActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = MovieDescriptionActivityBinding.inflate(layoutInflater)
        val imdb = intent.getStringExtra("imdbID")
        val title = intent.getStringExtra("movie_title")
        val viewModel: MovieDescriptionViewModel by viewModel()
        val plotSize = "full"

        imdb?.let {
            viewModel.plotPasser(imdb, plotSize)
        }

        viewModel.loading.observe(this) {
            binding.progressLoading.isVisible = it
            binding.textMovieTitle.isVisible = !it
            binding.textMovieDescription.isVisible = !it
        }

        viewModel.plot.observe(this) {
            it?.Plot?.let {
                binding.textMovieDescription.text = it
                binding.textMovieTitle.text = title
            }
        }
        setContentView(binding.root)
    }
}

