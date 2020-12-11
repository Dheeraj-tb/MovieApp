package com.example.testbooktutorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.CardViewBindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbooktutorial.MainActivity
import com.example.testbooktutorial.R
import com.example.testbooktutorial.databinding.CardBinding
import com.example.testbooktutorial.model.Result
import kotlin.collections.ArrayList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card.view.*
//ListAdapter<Result, MovieListViewHolder>(MovieListDiffCallback())
class MovieListAdapter(val result: List<Result>) : ListAdapter<Result, MovieListViewHolder>(MovieListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        print("On create ViewHOlder")
        val binding: CardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.card, parent, false)
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        print("On BindViewHOlder")
        holder.bind(result[position])
    }

    override fun getItemCount(): Int {
        return result.size
    }


}

//ListAdapter<Result, MovieListViewHolder>(MovieListDiffCallback())