package com.iniciandoaviddadev.omdb.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.iniciandoaviddadev.omdb.presentation.viewmodel.MainViewModel
import com.iniciandoaviddadev.omdb.databinding.ActivityMainBinding
import com.iniciandoaviddadev.omdb.presentation.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel: MainViewModel by viewModel()

        supportActionBar?.hide()

        /*binding.imageSearch.setOnClickListener {
            val search = binding.editSearch.text.toString().lowercase()
            viewModel.moviePasser(search)
        }*/

        binding.editSearch.addTextChangedListener {
            val search = binding.editSearch.text.toString().lowercase()
            viewModel.moviePasser(search)
        }

        viewModel.loading.observe(this) {
            binding.progressLoading.isVisible = it
        }

        viewModel.vision.observe(this) {
            when (it) {
                true -> {
                    binding.recyclerPoster.visibility = View.VISIBLE
                }

                false -> {
                    binding.recyclerPoster.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.movie.observe(this) {
            it?.Search?.let {
                val adapter = MovieAdapter(it, this)
                binding.recyclerPoster.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL, false
                )
                binding.recyclerPoster.adapter = adapter
            }
        }
        setContentView(binding.root)
    }
}