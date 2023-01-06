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
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {
    private val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        val imdb = args.imdb
        val title = args.title
        val viewModel: MovieDescriptionViewModel by viewModel()
        val plotSize = "full"

        imdb?.let {
            viewModel.plotPasser(imdb, plotSize)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressLoading.isVisible = it
            binding.textMovieTitle.isVisible = !it
            binding.textMovieDescription.isVisible = !it
        }

        viewModel.plot.observe(viewLifecycleOwner) {
            it?.Plot?.let {
                binding.textMovieDescription.text = it
                binding.textMovieTitle.text = title
            }
        }

        return binding.root
    }
}