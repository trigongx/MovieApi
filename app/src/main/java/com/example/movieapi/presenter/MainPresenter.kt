package com.example.movieapi.presenter

import com.example.movieapi.model.MovieApi
import com.example.movieapi.model.MovieModel
import com.example.movieapi.view.MovieView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter @Inject constructor(private val movieApi: MovieApi) {

    lateinit var view: MovieView

    fun getMovieDetails(name:String){
        movieApi.getMovie(name).enqueue(object : Callback<MovieModel>{
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                response.body()?.let {model ->
                    view.navigateToDetailFragment(model) }
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                    view.showToast(t.message.toString())
            }

        })
    }

    fun attachView(movieView: MovieView){
        this.view = movieView
    }

}