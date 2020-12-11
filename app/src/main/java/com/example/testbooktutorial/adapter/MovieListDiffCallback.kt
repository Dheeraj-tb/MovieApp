package com.example.testbooktutorial.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testbooktutorial.model.Result

class MovieListDiffCallback : DiffUtil.ItemCallback<Any>() {

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }
}