package com.example.testbooktutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testbooktutorial.adapter.MovieListAdapter
import com.example.testbooktutorial.model.MovieModel
import com.example.testbooktutorial.model.network.RetrofitClient
import com.example.testbooktutorial.model.network.RetrofitServices
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_fragment.*
import kotlinx.android.synthetic.main.fragment_main_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Mainfragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val retrofit = RetrofitClient().getInstance()
        val request = retrofit.create(RetrofitServices::class.java)

        val call = request.getMovies("b5a7aaff88a786d4924db7b0c9f8596e")

        println("ready")

        call.enqueue(object : Callback<MovieModel?> {
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                if (response.isSuccessful) {
                    val apiResponse: MovieModel? = response.body()
                    println("inside call")
                    //API response
                    println(apiResponse)
                    progress_bar.visibility = View.GONE
                    val linearLayoutManager = LinearLayoutManager(activity)
                    val adapter = MovieListAdapter()
                    recyclerView.layoutManager = linearLayoutManager
                    recyclerView.adapter = adapter

                    if (apiResponse != null) {
                        adapter.submitList(apiResponse.results)
                    }
                } else {
                    println("Request Error :: " + response.errorBody() + response.message() + response.code())
                }
            }

            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
                println("Network Error :: " + t.localizedMessage)
            }
        })


        println("recycler updated")

        return inflater.inflate(R.layout.fragment_main_fragment, container, false)


    }
}