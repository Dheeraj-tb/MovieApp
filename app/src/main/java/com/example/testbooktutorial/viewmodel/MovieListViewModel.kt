package com.example.testbooktutorial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testbooktutorial.model.MovieModel
import com.example.testbooktutorial.model.Result
import com.example.testbooktutorial.repositories.MovieListRepo
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    val movieRepo = MovieListRepo()
    val movieList: MutableLiveData<List<Result>> = MutableLiveData()

    fun getMovieList() {
        viewModelScope.launch {
            try {
                println("viewmodel")
                val response = movieRepo.fetchMovieData()
                if (response != null) {
                    onGetMovieListResponseSuccess(response)
                    println(movieList)
                }
            } catch (e: Exception) {

            }
        }
    }

    fun onGetMovieListResponseSuccess(response: MovieModel) {
        movieList.value = response.results
    }
}