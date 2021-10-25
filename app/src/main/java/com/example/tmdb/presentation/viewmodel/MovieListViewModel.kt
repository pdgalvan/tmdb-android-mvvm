package com.example.tmdb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieList = MutableLiveData<List<GetMovieByIdResponse>?>()
    val movieList: LiveData<List<GetMovieByIdResponse>?> get() = _movieList

    fun getMovieList() {
        viewModelScope.launch {
            val response = getMovieListUseCase.invoke()
            _movieList.postValue(response)
        }
    }

}
