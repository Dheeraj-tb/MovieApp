package com.example.testbooktutorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbooktutorial.R
import com.example.testbooktutorial.model.Result
import kotlin.collections.ArrayList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card.view.*

class MovieListAdapter(val result: List<Result>) : RecyclerView.Adapter<MovieListAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
                holder.bind(result[position])
        }

    override fun getItemCount(): Int {
        return result.size
    }
    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photo:ImageView = itemView.findViewById(R.id.movie_photo)
        private val title:TextView = itemView.findViewById(R.id.movie_title)
        private val overview:TextView = itemView.findViewById(R.id.movie_overview)
        private val rating:TextView = itemView.findViewById(R.id.movie_rating)

        fun bind(movie: Result) {
            println("${itemView.context} ")
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
            title.text = "Title: "+movie.title
            overview.text = movie.overview
            rating.text = "Rating : "+movie.vote_average.toString()
        }

    }
}


