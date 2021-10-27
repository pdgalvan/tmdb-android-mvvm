package com.example.tmdb.domain.repository

import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import javax.inject.Inject

interface TmdbRepository{

    suspend fun getMovieList(pageNumber: Int): List<GetMovieByIdResponse>?

    suspend fun getMovieById(movieId: Int): GetMovieByIdResponse?
}
