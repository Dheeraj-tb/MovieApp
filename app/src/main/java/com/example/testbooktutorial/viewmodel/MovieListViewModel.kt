package com.example.testbooktutorial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testbooktutorial.model.MovieModel
import com.example.testbooktutorial.model.Result
import com.example.testbooktutorial.repositories.MovieListRepo

class MovieListViewModel : ViewModel() {
    val movieRepo = MovieListRepo()
    val MovieList: MutableLiveData<List<Result>> = MutableLiveData()

    fun getMovieList() {
        try {
            println("viewmodel")
            val response = movieRepo.fetchMovieData()
            if (response != null) {
                onGetMovieListResponseSuccess(response)
                println(MovieList)
            }
        } catch (e: Exception) {

        }
    }

    fun onGetMovieListResponseSuccess(response: MovieModel) {
        MovieList.value = response.results
    }
}