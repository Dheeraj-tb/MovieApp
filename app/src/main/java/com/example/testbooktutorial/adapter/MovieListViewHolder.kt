package com.example.testbooktutorial.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbooktutorial.databinding.CardBinding
import com.example.testbooktutorial.model.Result

class MovieListViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {


    private val photo: ImageView = binding.moviePhoto
    private val title: TextView = binding.movieTitle
    private val overview: TextView = binding.movieOverview
    private val rating: TextView = binding.movieRating

    fun bind(movie: Result) {
        print("Bind")
        Glide.with(photo).load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
        title.text = "Title: "+movie.title
        overview.text = movie.overview
        rating.text = "Rating : "+movie.vote_average.toString()
    }

}