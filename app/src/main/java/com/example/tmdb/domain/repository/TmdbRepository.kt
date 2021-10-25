package com.example.tmdb.domain.repository

import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import javax.inject.Inject

interface TmdbRepository{

    suspend fun getMovieList(): List<GetMovieByIdResponse>?
}
