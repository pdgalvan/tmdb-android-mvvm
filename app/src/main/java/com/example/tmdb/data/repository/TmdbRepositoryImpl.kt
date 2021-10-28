package com.example.tmdb.data.repository

import com.example.tmdb.data.local.dao.MovieDao
import com.example.tmdb.data.remote.TmdbService
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.domain.repository.TmdbRepository
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val service: TmdbService
    ) : TmdbRepository{

    override suspend fun getMovieList(pageNumber: Int): List<GetMovieByIdResponse>? {
        val request = service.getMovieList(pageNumber)
        if(request.isSuccessful){
            return request.body()!!.result
        }
        return null
    }

    override suspend fun getMovieById(movieId: Int): GetMovieByIdResponse? {
        val request = service.getMovieDetail(movieId)
        if(request.isSuccessful){
            return  request.body()
        }
        return null
    }

}
