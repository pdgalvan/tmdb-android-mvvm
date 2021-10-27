package com.example.tmdb.data.remote

import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.data.remote.model.GetMovieListResponse
import com.example.tmdb.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {
    @GET("/3/movie/popular?api_key=$API_KEY")
    suspend fun getMovieList(
        @Query("page") pageNumber: Int
    ) : Response<GetMovieListResponse>

    @GET("/3/movie/{movieId}?api_key=$API_KEY")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: Int
    ) : Response<GetMovieByIdResponse>

}
