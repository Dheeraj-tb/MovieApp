package com.example.testbooktutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbooktutorial.R
import com.example.testbooktutorial.databinding.CardBinding
import com.example.testbooktutorial.model.Result

class MovieListViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object{
        fun create(inflater: LayoutInflater,
                   viewGroup: ViewGroup) : MovieListViewHolder {
            val binding = DataBindingUtil.inflate<CardBinding>(inflater, R.layout.card , viewGroup ,false)
            return MovieListViewHolder(binding)
        }
    }
    private val photo: ImageView = binding.moviePhoto
//    private val title: TextView = binding.movieTitle
//    private val overview: TextView = binding.movieOverview
//    private val rating: TextView = binding.movieRating
//
    fun bind(movie: Result) {
        print("Bind")


        val titleText = "Title: "+movie.title
        val ratingText = "Rating : "+movie.vote_average.toString()
        val overviewText = movie.overview

        binding.movieTitle.text = titleText
        binding.movieOverview.text = overviewText
        binding.movieRating.text = ratingText
        Glide.with(photo).load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
    }

}