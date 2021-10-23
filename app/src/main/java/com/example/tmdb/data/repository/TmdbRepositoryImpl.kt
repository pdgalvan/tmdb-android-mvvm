package com.example.tmdb.data.repository

import com.example.tmdb.data.remote.TmdbApi
import com.example.tmdb.data.remote.model.MovieResponse
import com.example.tmdb.domain.repository.TmdbRepository
import retrofit2.Response
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val api: TmdbApi
    ) : TmdbRepository{

    override suspend fun getMovieList(): Response<MovieResponse> {
        TODO("Not yet implemented")
    }

}
