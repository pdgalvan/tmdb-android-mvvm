package com.example.tmdb.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.tmdb.R
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.databinding.FragmentMovieDetailBinding
import com.example.tmdb.presentation.viewmodel.MovieDetailViewModel
import com.example.tmdb.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private val args: MovieDetailFragmentArgs by navArgs()
    private val binding: FragmentMovieDetailBinding by viewBinding()
    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch{
            viewModel.getMovieDetails(args.movieId)
        }

        viewModel.movieDetail.observe(viewLifecycleOwner,{movie ->
               if(movie != null) {
                   setMovieDetails(movie)
               }
        })
    }

    private fun setMovieDetails(movie: GetMovieByIdResponse) {
        Glide.with(requireContext())
            .load(Constants.IMAGE_URL.plus(movie.backdropPath))
            .centerCrop()
            .into(binding.imageView)

        Glide.with(requireContext())
            .load(Constants.IMAGE_URL.plus(movie.posterPath))
            .centerCrop()
            .into(binding.ivPoster)
        binding.tvMovieOverview.text = movie.overview
        binding.tvMovieTitle.text = movie.title
    }

}
