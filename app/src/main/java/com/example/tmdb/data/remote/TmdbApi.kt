package com.example.tmdb.data.remote

import com.example.tmdb.data.remote.model.GetMovieListResponse
import com.example.tmdb.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {
    @GET("/3/movie/popular?api_key=$API_KEY")
    suspend fun getMovieList() : Response<GetMovieListResponse>
}
