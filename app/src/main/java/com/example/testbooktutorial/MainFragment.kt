package com.example.testbooktutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testbooktutorial.adapter.MovieListAdapter
import com.example.testbooktutorial.model.Result
import com.example.testbooktutorial.viewmodel.MovieListViewModel
import com.example.testbooktutorial.viewmodel.MovieListViewModelFactory
import kotlinx.android.synthetic.main.fragment_main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() =  MainFragment().apply{

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        initViewModel()
        initData()
        initViewModelObserver()
        initAdapter()
    }

    private fun initData() {
        viewModel.getMovieList()
    }

    private lateinit var linearLayoutManager: LinearLayoutManager
    val adapter = MovieListAdapter()
    private fun initAdapter() {
        println("initadapter")
        linearLayoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
    }

    private fun initViewModelObserver() {
        println("observer")

        viewModel.movieList.observe(viewLifecycleOwner,  {
            onGetMovieListResponse(it)
        })
    }

    private fun onGetMovieListResponse(resultResponse: List<Result>?) {
        print("inside observer")
        if (resultResponse != null) {
            adapterListSubmit(resultResponse)
        }
    }

    lateinit var data : ArrayList<*>
    private fun adapterListSubmit(resultResponse: List<Result>) {
        data = resultResponse as ArrayList<*>
        println(data[0])
        adapter.submitList(data)
    }

    private lateinit var viewModel : MovieListViewModel
    private fun initViewModel(){
        @Suppress("DEPRECATION")
        viewModel = ViewModelProviders.of(this , MovieListViewModelFactory())
                .get(MovieListViewModel::class.java)
        println("initviewmodel")
    }
}