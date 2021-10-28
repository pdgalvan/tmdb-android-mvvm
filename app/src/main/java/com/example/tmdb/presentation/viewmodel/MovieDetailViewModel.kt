package com.example.tmdb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.domain.usecase.GetMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieByIdUseCase
) : ViewModel() {
    private val _movieDetail = MutableLiveData<GetMovieByIdResponse?>()
    val movieDetail: LiveData<GetMovieByIdResponse?> = _movieDetail


    suspend fun getMovieDetails(movieId: Int) {
        _movieDetail.value = getMovieDetailUseCase(movieId)
    }

}
