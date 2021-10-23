package com.example.tmdb.domain.repository

import com.example.tmdb.data.remote.model.MovieResponse
import retrofit2.Response

interface TmdbRepository {

    suspend fun getMovieList(): Response<MovieResponse>
}
