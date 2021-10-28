package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.TmdbRepository
import javax.inject.Inject


class GetMovieByIdUseCase @Inject constructor(
    private val repository: TmdbRepository
){
    suspend operator fun invoke(movieId: Int) = repository.getMovieById(movieId)
}
