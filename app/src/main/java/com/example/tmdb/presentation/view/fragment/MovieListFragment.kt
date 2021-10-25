package com.example.tmdb.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentMovieListBinding
import com.example.tmdb.presentation.adapter.MovieAdapter
import com.example.tmdb.presentation.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val binding: FragmentMovieListBinding by viewBinding()
    private val viewModel: MovieListViewModel by viewModels()
    private val adapter by lazy { MovieAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        viewModel.getMovieList()
        viewModel.movieList.observe(viewLifecycleOwner, {list ->
            if(list != null && list.isNotEmpty()){
                adapter.setList(list)
            }
        })

    }

    private fun initRecyclerView() {
        binding.rvMovies.adapter = adapter
        binding.rvMovies.layoutManager = LinearLayoutManager(this.context)
    }

}
