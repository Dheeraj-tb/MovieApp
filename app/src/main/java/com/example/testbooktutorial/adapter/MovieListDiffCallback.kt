package com.example.testbooktutorial.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testbooktutorial.model.Result

class MovieListDiffCallback : DiffUtil.ItemCallback<Result>() {

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return false
    }

    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return false
    }
}