package com.example.tmdb.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentMovieListBinding
import com.example.tmdb.presentation.adapter.MovieAdapter
import com.example.tmdb.presentation.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val binding: FragmentMovieListBinding by viewBinding()
    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var  movieAdapter : MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        loadMovieList()

    }

    private fun loadMovieList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.movieList.collect { pagingData ->
                movieAdapter.submitData(pagingData)
            }
        }
    }

    private fun initRecyclerView() {
        movieAdapter = MovieAdapter(object : MovieAdapter.ItemOnClickListener{
            override fun onItemClick(movieId: Int) {
                findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(movieId))
            }
        })

        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(context,3)
            adapter = movieAdapter
            setHasFixedSize(true)
        }
    }

}
