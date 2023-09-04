package com.example.movieapi.view

import com.example.movieapi.model.MovieModel

interface MovieView {

    fun navigateToDetailFragment(movieModel: MovieModel)
    fun showToast(msg:String)

}