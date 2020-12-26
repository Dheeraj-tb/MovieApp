package com.example.testbooktutorial.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testbooktutorial.model.MovieModel
import com.example.testbooktutorial.model.network.RetrofitClient
import com.example.testbooktutorial.model.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListRepo {
    private val _networkState = MutableLiveData<MovieListNetworkState>()
    val _MovieListResponse = MutableLiveData<MovieModel>()

    fun fetchMovieData() : MovieModel? {
        val retrofit = RetrofitClient().getInstance()
        val request = retrofit.create(RetrofitServices::class.java)

        val call = request.getMovies("b5a7aaff88a786d4924db7b0c9f8596e")
        println("outside call")

        call.enqueue(object : Callback<MovieModel?> {
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                if (response.isSuccessful) {
                    _MovieListResponse.value = response.body()
                    _networkState.postValue(MovieListNetworkState.LOADED)
                    println("inside call")
                    println(response.body()?.results?.get(0)?.title)
                }
            }

            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
                println("Network Error :: " + t.localizedMessage)
                _networkState.postValue(MovieListNetworkState.ERROR)
            }

        })
        println(_MovieListResponse.value)
        return _MovieListResponse.value
    }




}