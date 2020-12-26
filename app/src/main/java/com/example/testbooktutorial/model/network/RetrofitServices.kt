package com.example.testbooktutorial.model.network
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.testbooktutorial.model.MovieModel
import com.example.testbooktutorial.model.Result

import retrofit2.Response
import retrofit2.Call
interface RetrofitServices {

        @GET("now_playing")
        fun getMovies(@Query("api_key") key: String): Call<MovieModel>

}