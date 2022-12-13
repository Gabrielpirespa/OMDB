package com.iniciandoaviddadev.omdb.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iniciandoaviddadev.omdb.MovieResponse
import com.iniciandoaviddadev.omdb.R
import com.iniciandoaviddadev.omdb.databinding.MovieCardviewBinding
import com.iniciandoaviddadev.omdb.presentation.activity.MovieDescriptionActivity
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieList: List<MovieResponse>, val context: Context) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(private val binding: MovieCardviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieResponse) {

            binding.textTitle.text = item.Title.toString()

            Picasso.get()
                .load(item.Poster)
                .resize(300, 435)
                .centerCrop()
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.imagePoster)

            val intent = Intent(context, MovieDescriptionActivity::class.java)

            binding.cardPoster.setOnClickListener {
                intent.putExtra("imdbID", item.imdbID.toString())
                intent.putExtra("movie_title", item.Title.toString())
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieCardviewBinding.inflate(inflater)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}