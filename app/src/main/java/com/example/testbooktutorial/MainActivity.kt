package com.example.testbooktutorial

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
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


        initFragment()
    }

    private fun initFragment(){
        val fragment = Mainfragment()
        val transaction :FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frag, fragment)
        transaction.commit()
    }
}

// TODO event bus
// TODO RxJava vs Coroutine