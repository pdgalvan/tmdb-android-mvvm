package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.TmdbRepository
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val repository: TmdbRepository
){
    suspend operator fun invoke() = repository.getMovieList()
}
