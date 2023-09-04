package com.example.movieapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.movieapi.R
import com.example.movieapi.databinding.FragmentMainBinding
import com.example.movieapi.model.MovieModel
import com.example.movieapi.presenter.MainPresenter
import com.example.movieapi.view.MovieView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(),MovieView {

    private lateinit var binding:FragmentMainBinding

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        binding.btnSearch.setOnClickListener {
            presenter.getMovieDetails(binding.etFilmName.text.toString())
        }
    }

    override fun navigateToDetailFragment(movieModel: MovieModel) {
        findNavController().navigate(R.id.detailFragment, bundleOf("key" to movieModel))
        binding.etFilmName.text.clear()
    }

    override fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}