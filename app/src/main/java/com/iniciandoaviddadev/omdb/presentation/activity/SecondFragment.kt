package com.iniciandoaviddadev.omdb.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.iniciandoaviddadev.omdb.databinding.FragmentSecondBinding
import com.iniciandoaviddadev.omdb.presentation.viewmodel.MovieDescriptionViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        val imdb = args.imdb
        val viewModel: MovieDescriptionViewModel by viewModel()

        imdb?.let {
            viewModel.plotPasser(imdb)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressLoading.isVisible = it
        }

        viewModel.vision.observe(viewLifecycleOwner){
            binding.textMovieTitle.isVisible = it
            binding.textMovieDescription.isVisible = it
            binding.textGenres.isVisible = it
            binding.textRating.isVisible = it
            binding.textDescriptions.isVisible = it
        }

        viewModel.plot.observe(viewLifecycleOwner) {
            it?.let { it ->

                binding.textMovieTitle.text = it.Title
                binding.textMovieDescription.text = it.Plot

                Picasso.get()
                    .load(it.Poster)
                    .into(binding.imageMovie)

                when (it.Type) {
                    "movie", "series" -> {
                        binding.textDescriptions.text =
                            "${it.Year} - ${it.Runtime} - ${it.Language}"
                        binding.textGenres.text = it.Genre
                        binding.textRating.text = "IMDB: ${it.imdbRating}"
                    }
                    "game" -> {
                        binding.textDescriptions.text =
                            "${it.Year} - ${it.Type.replaceFirstChar { it.uppercase() }}" //método para deixar a primeira letra maiúscula
                        binding.textRating.text = "IMDB: ${it.imdbRating}"
                        binding.textGenres.text = it.Genre
                    }
                }
            }
        }

        return binding.root
    }
}