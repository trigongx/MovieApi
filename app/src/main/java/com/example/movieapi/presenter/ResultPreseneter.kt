package com.example.movieapi.presenter

import com.example.movieapi.model.MovieModel
import com.example.movieapi.view.ResultView

class ResultPresenter(private val resultView: ResultView) {

    fun getData(movieModel: MovieModel){
        resultView.showFilmDetail(movieModel)
    }

}
