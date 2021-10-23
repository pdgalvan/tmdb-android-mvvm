package com.example.tmdb.data.remote

import com.example.tmdb.data.remote.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {
    @GET("/3/movie/popular?api_key=1505a94c5a8ecd68c643b97138d1d815")
    suspend fun getMovieList() : Response<MovieResponse>
}
