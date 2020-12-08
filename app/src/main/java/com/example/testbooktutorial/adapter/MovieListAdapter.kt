package com.example.testbooktutorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.CardViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbooktutorial.MainActivity
import com.example.testbooktutorial.R
import com.example.testbooktutorial.databinding.CardBinding
import com.example.testbooktutorial.model.Result
import kotlin.collections.ArrayList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card.view.*

class MovieListAdapter(val result: List<Result>) : RecyclerView.Adapter<MovieListAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding: CardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.card, parent, false)
        return MovieListAdapter.MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
                holder.bind(result[position])
        }

    override fun getItemCount(): Int {
        return result.size
    }
    class MoviesViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {


        private val photo:ImageView = binding.moviePhoto
        private val title:TextView = binding.movieTitle
        private val overview:TextView = binding.movieOverview
        private val rating:TextView = binding.movieRating

        fun bind(movie: Result) {

            Glide.with(photo).load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
            title.text = "Title: "+movie.title
            overview.text = movie.overview
            rating.text = "Rating : "+movie.vote_average.toString()
        }

    }
}


