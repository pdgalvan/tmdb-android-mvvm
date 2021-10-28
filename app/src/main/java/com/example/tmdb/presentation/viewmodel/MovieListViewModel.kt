package com.example.tmdb.presentation.viewmodel

import androidx.lifecycle.*
import androidx.paging.*
import com.example.tmdb.domain.usecase.GetMovieListUseCase
import com.example.tmdb.presentation.view.MoviePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    val movieList = Pager(
        PagingConfig(pageSize = 20),
    ){
        MoviePagingSource(getMovieListUseCase)
    }.flow.cachedIn(viewModelScope)

}
