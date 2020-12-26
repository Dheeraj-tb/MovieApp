package com.example.testbooktutorial.repositories

enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}
class MovieListNetworkState(val status: Status, val msg: String) {

    companion object{
        val LOADED : MovieListNetworkState
        val LOADING : MovieListNetworkState
        val ERROR : MovieListNetworkState

        init{
            LOADED = MovieListNetworkState(Status.SUCCESS, "Success")
            LOADING = MovieListNetworkState(Status.RUNNING, "Loading")
            ERROR = MovieListNetworkState(Status.FAILED, "Something went wrong")

        }
    }
}
