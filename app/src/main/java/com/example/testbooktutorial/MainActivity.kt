package com.example.testbooktutorial

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testbooktutorial.adapter.MovieListAdapter
import com.example.testbooktutorial.model.MovieModel
import com.example.testbooktutorial.model.network.RetrofitClient
import com.example.testbooktutorial.model.network.RetrofitServices
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_fragment.view.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var retrofit = RetrofitClient().getInstance()
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
                    frag.progress_bar.visibility = View.GONE
                    frag.recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        if (apiResponse != null) {
                            adapter =
                                    MovieListAdapter(apiResponse.results)
                        }
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
    }

}