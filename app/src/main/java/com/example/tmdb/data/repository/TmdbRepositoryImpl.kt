package com.example.tmdb.data.repository

import com.example.tmdb.data.remote.TmdbApi
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.domain.repository.TmdbRepository
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val api: TmdbApi
    ) : TmdbRepository{

    override suspend fun getMovieList(): List<GetMovieByIdResponse>? {
        val request = api.getMovieList()
        if(request.isSuccessful){
            return request.body()!!.result
        }
        return null
    }

}
