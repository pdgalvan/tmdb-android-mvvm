package com.example.tmdb.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentMovieListBinding
import com.example.tmdb.presentation.adapter.MovieAdapter
import com.example.tmdb.presentation.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
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
//        }
//        viewModel.movieList.observe(viewLifecycleOwner, {list ->
//            if(list != null && list.isNotEmpty()){
//                movieAdapter.setList(list)
//            }
//        })

    }

    private fun loadMovieList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                movieAdapter.submitData(pagingData)
            }
        }
    }

    private fun initRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(context,3)
            adapter = movieAdapter
            setHasFixedSize(true)
        }
    }

}
