package com.example.testbooktutorial.model

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter


class Result(
        val adult: Boolean,
        val backdrop_path: String,
        val genre_ids: List<Int>,
        val id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int

){
//    doubt
//    @BindingAdapter("android:loadImage")
//    fun loadImage(imageView: ImageView, imageUrl: String) {
//        Glide.with(imageView).load("https://image.tmdb.org/t/p/w500${imageUrl}").into(imageView)
//    }
}