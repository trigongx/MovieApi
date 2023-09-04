package com.example.movieapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.movieapi.R
import com.example.movieapi.databinding.FragmentResultBinding
import com.example.movieapi.model.MovieModel
import com.example.movieapi.presenter.ResultPresenter
import com.example.movieapi.view.ResultView


class ResultFragment : Fragment(),ResultView {

    private lateinit var binding:FragmentResultBinding

    private val resultPresenter = ResultPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        val data = arguments?.getSerializable("key") as MovieModel
        resultPresenter.getData(data)
    }

    override fun showFilmDetail(movieModel: MovieModel) {
        with(binding){
            ivPosterFilm.load(movieModel.Poster)
            tvName.text = movieModel.Title
            tvYear.text = movieModel.Year
            tvGenre.text = movieModel.Genre
            tvAwards.text = movieModel.Awards
            tvRating.text = movieModel.imdbRating
        }
    }


}