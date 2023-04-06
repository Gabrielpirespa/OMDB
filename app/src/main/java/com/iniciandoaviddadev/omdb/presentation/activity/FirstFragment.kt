package com.iniciandoaviddadev.omdb.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.iniciandoaviddadev.omdb.R
import com.iniciandoaviddadev.omdb.databinding.FragmentFirstBinding
import com.iniciandoaviddadev.omdb.presentation.adapter.MovieAdapter
import com.iniciandoaviddadev.omdb.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment: Fragment(R.layout.fragment_first) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFirstBinding.inflate(inflater, container, false)

        val viewModel: MainViewModel by viewModel()

        binding.editSearch.addTextChangedListener {
            val search = binding.editSearch.text.toString().lowercase()
            viewModel.moviePasser(search)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressLoading.isVisible = it
        }

        viewModel.vision.observe(viewLifecycleOwner) {
            when (it) {
                true -> {
                    binding.recyclerPoster.visibility = View.VISIBLE
                }

                false -> {
                    binding.recyclerPoster.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.movie.observe(viewLifecycleOwner) {
            it?.Search?.let {
                val adapter = MovieAdapter(it, ::navigateToDetail)
                binding.recyclerPoster.layoutManager = GridLayoutManager(context, 2)
                binding.recyclerPoster.adapter = adapter
            }
        }
        return binding.root
    }
    private fun navigateToDetail(imdbID : String) {
        val action = FirstFragmentDirections.fromFirstFragmentToSecondFragment(imdbID)
        findNavController().navigate(action)
    }
}